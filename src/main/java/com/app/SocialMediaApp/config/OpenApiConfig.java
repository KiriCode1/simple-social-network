package com.app.SocialMediaApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI socialMediaAppOpenAPI() {
        return new OpenAPI().info(new Info().title("Social Media App")
        .description("Simple RESTful social network").version("1.0.0"));
    }
}
