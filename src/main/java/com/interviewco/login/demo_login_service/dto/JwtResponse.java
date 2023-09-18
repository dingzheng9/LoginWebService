package com.interviewco.login.demo_login_service.dto;

//Model JWT responses
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String username;
    private String role;
    private String name;

    public JwtResponse(String token, String username, String role, String name) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
