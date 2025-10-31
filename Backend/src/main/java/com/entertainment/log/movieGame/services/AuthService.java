package com.entertainment.log.movieGame.services;

import com.entertainment.log.movieGame.dto.*;

import java.util.UUID;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);

    UserResponse updateUser(UUID userId, UpdateUserRequest request);

}