package com.interviewco.login.demo_login_service.dto;

//Represents the login response data 
public class LoginResponse {
    private String username;
    private String name;
    private String role;
    private String token;  // This would be used for JWT or similar auth token later on

    // Default constructor
    public LoginResponse() {
    }

    // Parameterized constructor
    public LoginResponse(String username, String name, String role, String token) {
        this.username = username;
        this.name = name;
        this.role = role;
        this.token = token;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
