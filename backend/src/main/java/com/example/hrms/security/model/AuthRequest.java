package com.example.hrms.security.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
