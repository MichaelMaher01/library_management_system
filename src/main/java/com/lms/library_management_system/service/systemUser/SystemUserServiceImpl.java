package com.lms.library_management_system.service.systemUser;

import com.lms.library_management_system.model.SystemUser;
import com.lms.library_management_system.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemUserServiceImpl implements ISystemUserService {

    private final SystemUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SystemUser createUser(SystemUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Optional<SystemUser> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<SystemUser> getAllUsers() {
        return userRepo.findAll();

    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public SystemUser updateUser(Long id, SystemUser updatedUser) {
        return userRepo.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setRole(updatedUser.getRole());
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }
            return userRepo.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
