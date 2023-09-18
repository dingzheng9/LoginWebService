package com.interviewco.login.demo_login_service.service;

import com.interviewco.login.demo_login_service.dto.JwtResponse;
import com.interviewco.login.demo_login_service.dto.LoginRequest;
import com.interviewco.login.demo_login_service.model.User;

// Defines user-related service methods.
public interface UserService {

    User findByUsername(String username);

    JwtResponse authenticateUser(LoginRequest loginRequest);
}
