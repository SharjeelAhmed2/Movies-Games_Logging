package com.entertainment.log.movieGame.services;

import com.entertainment.log.movieGame.dto.AuthResponse;
import com.entertainment.log.movieGame.dto.LoginRequest;
import com.entertainment.log.movieGame.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}