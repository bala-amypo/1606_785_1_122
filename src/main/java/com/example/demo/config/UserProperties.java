package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserProperties {

    @Value("${app.security.username}")
    public String username;

    @Value("${app.security.password}")
    public String password;
}
