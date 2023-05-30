package com.mycompany.welcomehome.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.mycompany.welcomehome.security.jwt.AuthEntryPointJwt;
import com.mycompany.welcomehome.security.jwt.AuthTokenFilter;
import lombok.RequiredArgsConstructor;



@Configuration
@EnableMethodSecurity(prePostEnabled = true,
securedEnabled = true,
 jsr250Enabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;

  private final AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }


  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }


  
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	  
	http
	  .headers()
	  .frameOptions()
	  .disable()
	  .and()
      .cors()
      .and()
      .csrf()
      .disable()
      .exceptionHandling()
      .authenticationEntryPoint(unauthorizedHandler).and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeHttpRequests()
      .requestMatchers("/","/api/","/api/users/register/**","/api/users/login/**","/webjars/**","/swagger-ui.html","/swagger-resources/**","/v2/**","/swagger-ui/**")
      .permitAll()
      .anyRequest().authenticated()
        ;
    
    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
  }
}
