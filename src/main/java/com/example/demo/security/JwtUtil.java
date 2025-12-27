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
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "secret-key-demo";

    // Updated method to match AuthController
    public String generateToken(String email, String role, Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
