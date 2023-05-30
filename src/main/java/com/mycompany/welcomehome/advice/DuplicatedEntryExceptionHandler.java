package com.mycompany.welcomehome.advice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycompany.welcomehome.exception.DuplicatedEntryException;



@RestControllerAdvice
public class DuplicatedEntryExceptionHandler {
	
	@ExceptionHandler(DuplicatedEntryException.class)
	public ResponseEntity<Object> handleDuplicatedEntryException(DuplicatedEntryException ex) {
	   
		Map<String, String> errors = Map.of(ex.getField(),ex.getMessage());
		
        return new ResponseEntity<>(errors,HttpStatus.CONFLICT);
	}
}
