package com.mycompany.welcomehome.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper{

	@Override
	public User toUser(UserRegistrationDto userDto) {
		// TODO Auto-generated method stub
		return User.builder()
		.username(userDto.getUsername())
		.email(userDto.getEmail())
		.password(userDto.getPassword())
		.firstName(userDto.getFirstName())
		.lastName(userDto.getLastName())
		.phoneNumber(userDto.getLastName())
		.enabled(true)
		.build();
	} 

	@Override
	public User toUser(UserLoginDto userDto) {
		// TODO Auto-generated method stub
		return User.builder().username(userDto.getUsernameOrEmail())
		.password(userDto.getPassword()).build();
			}

	@Override
	public UserResponseDto toUserDTO(User user) {
		// TODO Auto-generated method stub
		return new UserResponseDto(user.getUsername(),user.getId(), 
				user.getEmail(), user.getFirstName(),
				user.getLastName(), user.getPhoneNumber(),user.getRoles());
	}

	@Override
	public List<UserResponseDto> toUserDTOs(List<User> users) {
		// TODO Auto-generated method stub
		return users.stream().map(u->toUserDTO(u)).toList();
	}


@Override


public Page<UserResponseDto> toUserDTOs(Page<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
