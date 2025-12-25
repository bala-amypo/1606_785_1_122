package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
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
                                .url("https://9156.32procr.amypo.ai")
                                .description("Production Server")
                ))
                .info(new Info()
                        .title("Influencer Campaign ROI Tracker API")
                        .version("1.0")
                        .description("API documentation"));
    }
}

