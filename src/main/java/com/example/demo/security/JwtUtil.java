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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String role) {

        return Jwts.builder()
                .setSubject("root")
                .addClaims(Map.of("role", role))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
