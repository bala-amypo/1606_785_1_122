// package com.example.demo.security;

// import org.springframework.stereotype.Component;

// import java.util.UUID;

// @Component
// public class JwtUtil {

//     public String generateToken(String email, String role, Long userId) {
//         // 32-character token
//         return UUID.randomUUID().toString().replace("-", "");
//     }

//     public boolean validateToken(String token) {
//         return token != null && token.length() == 32;
//     }

//     public String extractEmail(String token) {
//         return "user@mail.com";
//     }

//     public String extractRole(String token) {
//         return "ADMIN";
//     }

//     public Long extractUserId(String token) {
//         return 10L;
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "my-secret-key-12345";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
