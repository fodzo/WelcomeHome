package com.mycompany.welcomehome.user;


import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User{
	
	@Column(unique=true)
	private String username;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String password;
	
	@Column(unique=true)
	private String email;
	
	private List<Role> roles;
	
	
    private String firstName;
	
	
    private String lastName;
	
    private boolean enabled;
    
    @Column(unique=true)
    private String phoneNumber;
	
    private String profilImage;

   

	
	
	

	
}
