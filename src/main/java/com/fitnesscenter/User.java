package com.fitnesscenter;

public class User {
    private String username;
    private String password; // In real app, encrypt this
    private String email;
    private String location;
    private String role;

    public User(String username, String password, String email, String location, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
        this.role = role;
    }

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getLocation() { return location; }
    public String getRole() { return role; }
}