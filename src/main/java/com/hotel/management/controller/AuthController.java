package com.hotel.management.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.hotel.management.dto.RegisterRequest;
import com.hotel.management.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}
