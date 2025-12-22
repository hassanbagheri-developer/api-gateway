/*
package com.example.api_gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String clientSecret;

    @Bean
    public WebClient keycloakClient() {
        return WebClient.builder()
                .baseUrl(clientSecret)
                .build();
    }
}
*/
