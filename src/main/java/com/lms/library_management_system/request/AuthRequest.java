package com.lms.library_management_system.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
