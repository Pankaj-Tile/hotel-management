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

        // 🔎 Duplicate checks
        if (userRepository.existsByUsername(request.getUsername())) {
            return "Username already exists";
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        if (userRepository.existsByMobileNumber(request.getMobileNumber())) {
            return "Mobile number already exists";
        }

        // 🧱 Build User entity
        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setAddress(request.getAddress());

        // 🔐 Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // 👤 Role handling (default USER)
        UserRole role;
        try {
            role = request.getRole() == null
                    ? UserRole.USER
                    : UserRole.valueOf(request.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Invalid role provided";
        }

        user.setRole(role);

        // 💾 Save user
        userRepository.save(user);

        return "User registered successfully";
    }
}
