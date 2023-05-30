package com.mycompany.welcomehome.validator;

import java.time.LocalDate;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import com.mycompany.welcomehome.annotation.DateRange;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String startDate;
    private String endDate;

    @Override
    public void initialize(DateRange constraintAnnotation) {
        this.startDate = constraintAnnotation.startDate();
        this.endDate = constraintAnnotation.endDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        LocalDate start = (LocalDate) beanWrapper.getPropertyValue(startDate);
        LocalDate end = (LocalDate) beanWrapper.getPropertyValue(endDate);
        
        if (start != null && end != null && start.isAfter(end)) {
           
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                   .addPropertyNode(endDate) // specify the error field
                   .addConstraintViolation();
            return false;
        }
        return true;
    }

	
}

