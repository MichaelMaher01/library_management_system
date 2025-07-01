package com.lms.library_management_system.repository;

import com.lms.library_management_system.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUser , Long> {
    Optional<Object> findByUsername(String username);

}
