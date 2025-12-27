package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // ❌ Disable CSRF for APIs & Swagger
            .csrf(csrf -> csrf.disable())

            // 🔐 Authorization rules
            .authorizeHttpRequests(auth -> auth

                // ✅ Allow authentication-related endpoints (important for tests)
                .requestMatchers("/auth/**", "/login", "/register").permitAll()

                // ✅ Swagger access
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**")
                .hasAnyRole("ADMIN", "MARKETER")

                // ✅ READ access: ADMIN + MARKETER
                .requestMatchers(HttpMethod.GET,
                        "/campaigns/**",
                        "/influencers/**",
                        "/discounts/**",
                        "/sales/**",
                        "/roi/**"
                ).hasAnyRole("ADMIN", "MARKETER")

                // ✅ CREATE access: ADMIN only
                .requestMatchers(HttpMethod.POST,
                        "/campaigns/**",
                        "/influencers/**",
                        "/discounts/**",
                        "/sales/**",
                        "/roi/**"
                ).hasRole("ADMIN")

                // ✅ UPDATE access: ADMIN only
                .requestMatchers(HttpMethod.PUT,
                        "/campaigns/**",
                        "/influencers/**",
                        "/discounts/**",
                        "/sales/**",
                        "/roi/**"
                ).hasRole("ADMIN")

                // ✅ DELETE access: ADMIN only
                .requestMatchers(HttpMethod.DELETE,
                        "/campaigns/**",
                        "/influencers/**",
                        "/discounts/**",
                        "/sales/**",
                        "/roi/**"
                ).hasRole("ADMIN")

                // 🔒 Everything else requires authentication
                .anyRequest().authenticated()
            )

            // ✅ Enable form login (browser & Swagger friendly)
            .formLogin()

            // ✅ Enable logout
            .and()
            .logout(logout -> logout.permitAll());

        return http.build();
    }

    // 👤 In-memory users (safe for testing & demo)
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {

        var admin = org.springframework.security.core.userdetails.User
                .withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        var marketer = org.springframework.security.core.userdetails.User
                .withUsername("marketer")
                .password(passwordEncoder.encode("marketer123"))
                .roles("MARKETER")
                .build();

        return new InMemoryUserDetailsManager(admin, marketer);
    }

    // 🔑 Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
