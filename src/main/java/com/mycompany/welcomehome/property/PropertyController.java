package com.mycompany.welcomehome.property;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.welcomehome.security.jwt.JwtUtils;
import com.mycompany.welcomehome.shared.UriUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Context;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/properties/")
public class PropertyController {
	
	private final IPropertyService propertyService;
	
	private final JwtUtils jwtUtils;
	
	private final IPropertyMapper propertyMapper;
	
	
@PostMapping
@ApplyPropertyAspect
public ResponseEntity<?> addProperty(@Valid PropertyRequestDto property, @Context HttpServletRequest request)
{
	String usernameOrEmail = jwtUtils.getUserNameFromJwtToken(request);
	Property newProperty = propertyMapper.toProperty(property);
	newProperty = propertyService.addProperty(newProperty, usernameOrEmail);
	URI location = UriUtil.buildUriWithId("/properties", newProperty.getId());

	return ResponseEntity.created(location).body("Property added successfully.");
}
@GetMapping
public ResponseEntity<?> properties(@Context HttpServletRequest request)
{
	return ResponseEntity.ok(propertyService.getProperties(jwtUtils.getUserNameFromJwtToken(request)));
}
}
