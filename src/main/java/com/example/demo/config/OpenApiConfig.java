package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server()
                                .url("https://9130.pro604cr.amypo.ai/")
                                .description("Production Server")
                ))
                .info(new Info()
                        .title("Influencer Campaign ROI Tracker API")
                        .version("1.0")
                        .description("API documentation"))
                
                // 🔐 Add security requirement (shows Authorize button)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                
                // 🔐 Define security scheme
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .name("bearerAuth")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ));
    }
}
