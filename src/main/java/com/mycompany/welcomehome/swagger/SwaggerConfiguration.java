package com.mycompany.welcomehome.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Configuration
public class SwaggerConfiguration {
	private ApiKey apiKey() { 
	    return new ApiKey("JWT", "Authorization", "header"); 
	}
	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}
    private ApiInfo apiInfo() {
        return new ApiInfo("REST APIs Home rental App",
                "REST API",
                "1.0",
                "Terms of service",
                new Contact("", "", ""),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		 
        		.groupName("API AUTH SERVER")
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
			    .securitySchemes(Arrays.asList(apiKey()))
				
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mycompany.welcomehome"))
                .paths(PathSelectors.any())
                .build();
                
    }
}