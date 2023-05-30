package com.mycompany.welcomehome.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UserRegistrationDto {
	
/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

@NotEmpty(message="the username is required")
private String username;

@NotEmpty(message="the username is required")
@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+}{:;\"\'?/.,\\\\-])(?!.*\\s).{8,}$", message = "Please enter a strong password")
private String password;

@NotEmpty(message="Email is required")
@Email(message="invalid email")
private String email;


@NotEmpty(message="firstName is required")
private String firstName;

@NotEmpty(message="LastName is required")
private String lastName;

@Pattern(regexp="^(\\+|00)(\\d{1,3})?[ -]*(\\d{1,3}[ -]*){1,3}\\d{4}$",message="Invalid phone number")
private String phoneNumber;

/**
 * @return the phoneNumber
 */
public String getPhoneNumber() {
	return phoneNumber;
}

/**
 * @param phoneNumber the phoneNumber to set
 */
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}




}