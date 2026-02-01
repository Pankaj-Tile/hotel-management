package com.hotel.management.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.management.dto.RegisterRequest;
import com.hotel.management.entity.User;
import com.hotel.management.entity.UserRole;
import com.hotel.management.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        // default role USER if not provided
        UserRole role = request.getRole() == null
                ? UserRole.USER
                : UserRole.valueOf(request.getRole().toUpperCase());

        user.setRole(role);

        userRepository.save(user);

        return "User registered successfully";
    }
}
