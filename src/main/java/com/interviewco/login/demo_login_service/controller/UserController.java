package com.interviewco.login.demo_login_service.controller;

import com.interviewco.login.demo_login_service.dto.JwtResponse;
import com.interviewco.login.demo_login_service.dto.LoginRequest;
import com.interviewco.login.demo_login_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Handles user-related operations
//Might not use this
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public JwtResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        return userService.authenticateUser(loginRequest);
    }
    
}
