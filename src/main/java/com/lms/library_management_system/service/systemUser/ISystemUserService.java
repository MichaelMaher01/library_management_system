package com.lms.library_management_system.service.systemUser;

import com.lms.library_management_system.model.SystemUser;

import java.util.List;
import java.util.Optional;

public interface ISystemUserService {
    SystemUser createUser(SystemUser user);
    Optional<SystemUser> getUserById(Long id);
    List<SystemUser> getAllUsers();
    void deleteUser(Long id);
    SystemUser updateUser(Long id, SystemUser user);
}
