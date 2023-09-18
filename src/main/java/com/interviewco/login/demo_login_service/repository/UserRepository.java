package com.interviewco.login.demo_login_service.repository;

import com.interviewco.login.demo_login_service.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Defines methods to interact with the user database
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
