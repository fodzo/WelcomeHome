package com.mycompany.welcomehome.security.jwt;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class Payload {
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 
private Date issuedAt;
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private Date expiresAt;
private String subject;
}
