package com.mycompany.welcomehome.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.mycompany.welcomehome.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ResourceNotFoundExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<String> handleInResourceNotFoundException(ResourceNotFoundException ex) {
	        
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
}

}
