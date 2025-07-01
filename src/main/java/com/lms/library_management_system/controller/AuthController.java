package com.lms.library_management_system.controller;

import com.lms.library_management_system.model.SystemUser;
import com.lms.library_management_system.repository.SystemUserRepository;
import com.lms.library_management_system.request.AuthRequest;
import com.lms.library_management_system.response.AuthResponse;
import com.lms.library_management_system.security.jwt.JwtUtils;
import com.lms.library_management_system.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        String token = authService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SystemUser user) {
        authService.register(user);
        return ResponseEntity.ok("User registered successfully!");
    }
}
