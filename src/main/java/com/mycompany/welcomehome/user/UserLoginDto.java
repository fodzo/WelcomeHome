package com.mycompany.welcomehome.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginDto {
	
	@NotEmpty(message="This field is required")
	private String usernameOrEmail;
	@NotEmpty(message="the password is required")
	private String password;
}
