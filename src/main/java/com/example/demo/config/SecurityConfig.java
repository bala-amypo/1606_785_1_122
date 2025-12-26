package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
      @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").hasAnyRole("ADMIN", "MARKETER")
            .requestMatchers("/admin/**").hasRole("ADMIN")     // only admin
            .requestMatchers("/marketing/**").hasRole("MARKETER") // only marketer
            .anyRequest().authenticated()
        )
        .formLogin()
        .and()
        .logout().permitAll();

    return http.build();
}


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


@Bean
public PasswordEncoder passwordEncoder() {
    return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
}
}