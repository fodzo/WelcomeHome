package com.mycompany.welcomehome.advice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadCredentialsExceptionHandler {
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<Object> handleBadCredentials(BadCredentialsException ex) {
		Map<String, String> errors = Map.of("message","Invalid login or password");
        return new ResponseEntity<>(errors,HttpStatus.UNAUTHORIZED);
	}
}
