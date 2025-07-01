package com.lms.library_management_system.controller;

import com.lms.library_management_system.model.SystemUser;
import com.lms.library_management_system.service.systemUser.SystemUserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class SystemUserController {
    private final SystemUserServiceImpl userService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SystemUser> createUser(@RequestBody SystemUser user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
    public ResponseEntity<List<SystemUser>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/user/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user/{id}/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SystemUser> updateUser(@PathVariable Long id, @RequestBody SystemUser user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}

