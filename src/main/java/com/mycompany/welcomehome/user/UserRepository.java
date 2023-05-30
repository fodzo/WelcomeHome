package com.mycompany.welcomehome.user;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{
@Query(value="SELECT u FROM User u WHERE u.username=:login OR u.email=:login")
Optional<User> findByUsernameOrEmail(@Param("login") String usernameOrEmail);

@Query(value="SELECT u FROM User u WHERE u.phoneNumber = :phone")
Optional<User> findByPhoneNumber(@Param("phone") String phoneNumber);

	
}
