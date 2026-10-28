package com.example.api_gateway.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Api(tags = "API", value = "")
@RequestMapping("/public/test")
@RefreshScope
@DependsOn("applicationConfigurations")
public class TestController {

    @Value("${spring.application.version:unknown}")
    private String version;

    @GetMapping
    public String hello() {
        System.out.println(version);
        return "Hello World "+ version;
    }

}
