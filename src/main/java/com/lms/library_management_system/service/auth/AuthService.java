package com.lms.library_management_system.service.auth;

import com.lms.library_management_system.model.SystemUser;
import com.lms.library_management_system.repository.SystemUserRepository;
import com.lms.library_management_system.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authManager;
    private final SystemUserRepository userRepo;
    private final JwtUtils jwtService;
    private final PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SystemUser user = (SystemUser) userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return jwtService.generateToken(user);
    }

    public void register(SystemUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
}
