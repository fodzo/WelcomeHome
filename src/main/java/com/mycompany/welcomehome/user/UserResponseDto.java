package com.mycompany.welcomehome.user;

import java.util.List;

import lombok.Data;
@Data
public class UserResponseDto {
     	
	private String username;
	
	private long id;
	
	private List<Role> roles;
	
	public UserResponseDto(String username, long id, String email, String firstName, String lastName,
			String phoneNumber,List<Role> roles) {
		
		this.username = username;
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.roles=roles;
	}



	private String email;
	
	
    private String firstName;
	
	
    private String lastName;
	
	
    private String phoneNumber;
	
    
}
