package com.example.api_gateway.api.dto;

import lombok.Data;

@Data
public class TokenRequest {
    private String username;
    private String password;
}
