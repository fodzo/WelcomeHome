package com.mycompany.welcomehome.property;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Aspect
@Component
@RequiredArgsConstructor
public class PropertyAspect {
	
    
    private final HttpServletRequest request;

    @AfterReturning(pointcut = "execution(@com.mycompany.welcomehome.property.ApplyPropertyAspect * com.mycompany.welcomehome.property.PropertyController.*(..))", returning = "returnValue")
    public void addHateoasLinks(JoinPoint joinPoint, Object returnValue) {
    	
    	Class<PropertyController> target = PropertyController.class;
        String selfLink = WebMvcLinkBuilder.linkTo(target)
                .slash(joinPoint.getSignature().getName())
                .withSelfRel()
                .getHref();

        
        String reservationsLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PropertyController.class)
                .properties(request))
                .withRel("reservations")
                .toUri()
                .getPath();

        
        if (returnValue instanceof EntityModel) {
            EntityModel<?> entityModel = (EntityModel<?>) returnValue;
            entityModel.add(Link.of(selfLink, "self"));
            entityModel.add(Link.of(reservationsLink, "properties"));
        } else {
            throw new UnsupportedOperationException("HATEOAS response can only be applied to EntityModel");
        }

    	
    }
}
