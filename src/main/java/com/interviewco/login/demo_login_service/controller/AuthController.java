package com.interviewco.login.demo_login_service.controller;

import com.interviewco.login.demo_login_service.dto.JwtResponse;
import com.interviewco.login.demo_login_service.dto.LoginRequest;
import com.interviewco.login.demo_login_service.security.UserDetailsImpl;
import com.interviewco.login.demo_login_service.service.CustomUserDetailsService;
import com.interviewco.login.demo_login_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Handles authentication and issues JWT tokens
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
//    	System.out.println("LOG: Username - " + loginRequest.getUsername());
//    	System.out.println("LOG: Password - " + loginRequest.getPassword());

        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            // Generate JWT token if authentication is successful
            if (authentication.isAuthenticated()) {
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
//                System.out.println("LOG:userDetails:" + userDetails);
                if (userDetails instanceof UserDetailsImpl) {
                    UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetails;
//                    System.out.println("LOG:userDetailsImpl:" + userDetailsImpl);
                    String jwtToken = jwtUtil.generateToken(userDetailsImpl);
//                    System.out.println("LOGjwtToken:" + jwtToken);

                    // Return the JWT token in the response
                    JwtResponse jwtResponse = new JwtResponse(jwtToken, userDetailsImpl.getUsername(), userDetailsImpl.getRole(), userDetailsImpl.getName());
                    return ResponseEntity.ok(jwtResponse);
                }
            }
        } catch (BadCredentialsException e) {
            // Handle authentication failure
//        	System.out.println("LOG:BadCredential-1");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Handle other authentication failures
//        System.out.println("LOG:BadCredential-2");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
