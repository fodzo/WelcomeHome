package com.mycompany.welcomehome.reservation;
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
public class ReservationAspect {
	
    
    private final HttpServletRequest request;

    @AfterReturning(pointcut = "execution(@com.mycompany.welcomehome.reservation.ApplyReservationAspect * com.mycompany.welcomehome.reservation.ReservationController.*(..))", returning = "returnValue")
    public void addHateoasLinks(JoinPoint joinPoint, Object returnValue) {
    	
    	Class<ReservationController> target=ReservationController.class;
        String selfLink = WebMvcLinkBuilder.linkTo(target)
                .slash(joinPoint.getSignature().getName())
                .withSelfRel()
                .getHref();

        
        String reservationsLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ReservationController.class)
                .tenantReservations(request))
                .withRel("reservations")
                .toUri()
                .getPath();

        
        if (returnValue instanceof EntityModel) {
            EntityModel<?> entityModel = (EntityModel<?>) returnValue;
            entityModel.add(Link.of(selfLink, "self"));
            entityModel.add(Link.of(reservationsLink, "reservations"));
        } else {
            throw new UnsupportedOperationException("HATEOAS response can only be applied to EntityModel");
        }

    	
    }
}
