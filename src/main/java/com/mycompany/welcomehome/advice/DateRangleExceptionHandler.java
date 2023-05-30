package com.mycompany.welcomehome.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycompany.welcomehome.exception.DateRangeException;

@ControllerAdvice
public class DateRangleExceptionHandler {

    @ExceptionHandler(DateRangeException.class)
    public ResponseEntity<Object> handleDateRangeException(DateRangeException ex) {
 
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
