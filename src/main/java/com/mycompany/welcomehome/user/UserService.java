package com.mycompany.welcomehome.user;


import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.welcomehome.exception.DuplicatedEntryException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	
    @Override
	public User registerUser(User user) throws DuplicatedEntryException {
    	
		if(userRepository.findByUsernameOrEmail(user.getUsername()).isPresent())
			throw new DuplicatedEntryException("email", "This email is taken");
		
		if(userRepository.findByUsernameOrEmail(user.getUsername()).isPresent())
			throw new DuplicatedEntryException("username", "This username is taken");
		
		if(userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent())
			throw new DuplicatedEntryException("phoeNumber", "This phoneNumber is taken");
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setRoles(List.of(Role.ROLE_USER));
		return userRepository.save(user);
	}


    @Override
	public List<User> users() {
		
		return userRepository.findAll();
	}
	

}
