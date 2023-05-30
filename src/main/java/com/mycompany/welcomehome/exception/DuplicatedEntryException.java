package com.mycompany.welcomehome.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DuplicatedEntryException extends Exception{

private static final long serialVersionUID = 1L;
private String field;
private String message;
}
