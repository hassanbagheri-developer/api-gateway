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
                                "/api/swagger-ui.html",
                                "/api/swagger-ui/**",
                                "/api/v3/api-docs/**",
                                "/api/oauth2/token",
                                "/api/core-service/oauth2/**",
                                "/api/core-service/oauth2/register",
                                "/api/core-service/oauth2/registerV2",

                                "/api/core-service/v3/api-docs/**",
                                "/api/core-service/swagger-ui/**",
                                "/api/core-service/public/**",



                                // swagger for api-gateway
                                "/api/api-gateway/v3/api-docs/**",
                                "/api/api-gateway/swagger-ui/**",
                                "/api/api-gateway/public/**",
                                "/api/webjars/**",

                                // swagger for marketPlace
                                "/api/marketPlace/v3/api-docs/**",
                                "/api/marketPlace/swagger-ui/**",
                                "/api/marketPlace/public/**"
                        ).permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .build();
    }
}






