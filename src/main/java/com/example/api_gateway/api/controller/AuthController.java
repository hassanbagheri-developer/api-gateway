package com.example.api_gateway.api.controller;

import com.example.api_gateway.api.dto.TokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/oauth2")
@RequiredArgsConstructor
public class AuthController {

    @Value("${keycloak.for-api-api-gateway.client_id}")
    private String clientId;

    @Value("${keycloak.for-api-api-gateway.client_secret}")
    private String clientSecret;


    private final WebClient keycloakClient;


    @PostMapping("/token")
    public Mono<Map<String, Object>> token(@RequestBody TokenRequest req) {
        return keycloakClient.post()
                .uri("/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", "password")
                        .with("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("username", req.getUsername())
                        .with("password", req.getPassword()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }
}
