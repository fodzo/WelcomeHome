package com.mycompany.welcomehome.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceNotFoundException extends Exception{

private static final long serialVersionUID = 1L;

private String message;

}
