package com.entertainment.log.movieGame.services;


import com.entertainment.log.movieGame.dto.AuthResponse;
import com.entertainment.log.movieGame.dto.LoginRequest;
import com.entertainment.log.movieGame.dto.RegisterRequest;
import com.entertainment.log.movieGame.dto.UserResponse;
import com.entertainment.log.movieGame.model.UserModel;
import com.entertainment.log.movieGame.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already registered");
        }

        UserModel user = new UserModel(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );

        UserModel saved = userRepository.save(user);

        UserResponse userDto = new UserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRole(),
                saved.getCreatedAt()
        );

        // JWT not implemented yet; return null token for now
        return new AuthResponse(null, userDto);
    }

    @Override
    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        UserModel user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        UserResponse userDto = new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );

        // JWT not implemented yet; return null token for now
        return new AuthResponse(null, userDto);
    }
}