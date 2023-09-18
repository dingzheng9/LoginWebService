package com.interviewco.login.demo_login_service.service;

import com.interviewco.login.demo_login_service.dto.JwtResponse;
import com.interviewco.login.demo_login_service.dto.LoginRequest;
import com.interviewco.login.demo_login_service.model.User;
import com.interviewco.login.demo_login_service.repository.UserRepository;
import com.interviewco.login.demo_login_service.security.UserDetailsImpl;
import com.interviewco.login.demo_login_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

// Implements the UserService interface
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService; // Import the correct package

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Incorrect username or password");
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        // Cast to your implementation to access additional methods
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userDetails;
        return new JwtResponse(jwt, userDetailsImpl.getUsername(), userDetailsImpl.getRole(), userDetailsImpl.getName());
    }
}
