package com.example.api_gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartupVersionLogger {

    @Value("${spring.application.version:unknown}")
    private String version;

    @EventListener(ApplicationReadyEvent.class)
    public void logAfterStartup() {
        log.info("========================================");
        log.info("🚀 Api-Gateway Version: {}", version);
        log.info("========================================");
    }
}
