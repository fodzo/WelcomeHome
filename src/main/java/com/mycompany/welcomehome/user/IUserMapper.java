package com.mycompany.welcomehome.user;

import java.util.List;
import org.springframework.data.domain.Page;



public interface IUserMapper {

User toUser(UserRegistrationDto userDto);

User toUser(UserLoginDto userDto);

UserResponseDto toUserDTO(User user);

List<UserResponseDto> toUserDTOs(List<User> users);

Page<UserResponseDto> toUserDTOs(Page<User> users);
}
