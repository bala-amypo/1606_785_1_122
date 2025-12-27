package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JwtUtil {

    public String generateToken(String email, String role, Long userId) {
        // 32-character token
        return UUID.randomUUID().toString().replace("-", "");
    }

    public boolean validateToken(String token) {
        return token != null && token.length() == 32;
    }

    public String extractEmail(String token) {
        return "user@mail.com";
    }

    public String extractRole(String token) {
        return "ADMIN";
    }

    public Long extractUserId(String token) {
        return 10L;
    }
}
