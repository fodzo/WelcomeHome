package com.mycompany.welcomehome.advice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.jsonwebtoken.ExpiredJwtException;


@RestControllerAdvice
public class ExpiredJwtExceptionHandler{
	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<Object> handleJWTExpiration(ExpiredJwtException ex) {
	   
		Map<String, String> errors = Map.of("message","JWT Token expired");
        return new ResponseEntity<>(errors,HttpStatus.UNAUTHORIZED);
	}
}
