package com.example.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(auth -> auth
                        .pathMatchers(
                                // swagger for gateway
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/oauth2/token",
                                "/core-service/oauth2/getToken",
                                "/core-service/oauth2/register",

                                "/core-service/v3/api-docs/**",
                                "/core-service/swagger-ui/**",
                                "/core-service/public/**",

                                // swagger for marketPlace
                                "/api-gateway/v3/api-docs/**",
                                "/api-gateway/swagger-ui/**",
                                "/api-gateway/public/**",
                                "/webjars/**",

                                // swagger for marketPlace
                                "/marketPlace/v3/api-docs/**",
                                "/marketPlace/swagger-ui/**",
                                "/marketPlace/public/**"
                        ).permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .build();
    }
}
