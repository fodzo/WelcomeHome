package com.mycompany.welcomehome.security.jwt;


import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.mycompany.welcomehome.security.services.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import jakarta.servlet.http.HttpServletRequest;


@Component
public class JwtUtilsImpl implements JwtUtils {
  

  @Value("${app.jwtSecret}")
  private String jwtSecret;
  
  @Value("${app.jwtExpirationMs}") 
  private int jwtExpirationMs;

  public Map<String,Payload> generateJwtToken(Authentication authentication) {

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
    Date now=new Date();
    Date date=new Date(now.getTime() + jwtExpirationMs);
    String jwt=Jwts.builder()
        .setSubject((userPrincipal.getUsername()))
        .setIssuedAt(new Date())
        .setExpiration(date)
        .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
        .compact();
    return Map.of(jwt,new Payload(now, date,userPrincipal.getUsername()));
        
  }

  private String parseJwt(HttpServletRequest request) {
	    String headerAuth = request.getHeader("Authorization");

	    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
	      return headerAuth.substring(7, headerAuth.length());
	    }

	    return null;
	  }
  public String getUserNameFromJwtToken(HttpServletRequest request) {
    return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
    		.build().parseClaimsJws(parseJwt(request)).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
    	
    	Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
		.build().parseClaimsJws(authToken);
      return true;
    } catch (SecurityException e) {
      
    } catch (MalformedJwtException e) {
      
    } catch (UnsupportedJwtException e) {
     
    } catch (IllegalArgumentException e) {
         }

    return false;
  }
}
