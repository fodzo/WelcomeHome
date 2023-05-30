package com.mycompany.welcomehome.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mycompany.welcomehome.validator.DateRangeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface DateRange {
    String message() default "Start date must be before end date";
    
    String startDate() default "startDate"; // specify the default start date field name
    String endDate() default "endDate"; //
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

