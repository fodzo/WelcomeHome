package com.mycompany.welcomehome.security.jwt;


import java.util.Map;
import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;

public interface JwtUtils {
	
public Map<String, Payload> generateJwtToken(Authentication authentication);

public String getUserNameFromJwtToken(HttpServletRequest request);
	   
public boolean validateJwtToken(String authToken);
	   

}
