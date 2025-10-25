package com.entertainment.log.movieGame.dto;


public class AuthResponse {
    private String accessToken; // can be null for now
    private UserResponse user;

    public AuthResponse() {}

    public AuthResponse(String accessToken, UserResponse user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public UserResponse getUser() { return user; }
    public void setUser(UserResponse user) { this.user = user; }
}