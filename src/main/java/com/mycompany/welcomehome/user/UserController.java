package com.mycompany.welcomehome.user;

import java.net.URI;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mycompany.welcomehome.exception.DuplicatedEntryException;
import com.mycompany.welcomehome.security.jwt.JwtUtils;
import com.mycompany.welcomehome.security.jwt.Payload;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

	 private final AuthenticationManager authenticationManager;

	 private final JwtUtils jwtUtils;

      private final IUserService userService;
      private final UserMapper userMapper;

@GetMapping("/")
public ResponseEntity<?> registerUser()
{

	return ResponseEntity.status(HttpStatus.OK).
			body(userMapper.toUserDTOs(userService.users()));
}
@PostMapping("/login")
public ResponseEntity<?> authenticateUser(@Valid UserLoginDto loginRequest) {

  Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

  SecurityContextHolder.getContext().setAuthentication(authentication);
  Map<String, Payload> jwtInfos = jwtUtils.generateJwtToken(authentication);
  String jwtToken=(String) jwtInfos.keySet().toArray()[0];
  return ResponseEntity.ok().header("JWT", jwtToken).body(jwtInfos.get(jwtToken));
                      
}

@PostMapping("/register")
public ResponseEntity<?> register(@Valid UserRegistrationDto userDto) throws DuplicatedEntryException {
   
    User registeredUser = userService.registerUser(userMapper.toUser(userDto));
    UserResponseDto registeredUserDto = userMapper.toUserDTO(registeredUser);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(registeredUserDto.getId())
            .toUri();

    return ResponseEntity.created(location).body(registeredUserDto);
}

}
