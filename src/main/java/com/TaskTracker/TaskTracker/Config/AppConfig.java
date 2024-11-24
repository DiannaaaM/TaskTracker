package com.TaskTracker.TaskTracker.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Long defaultId() {
        return 1L;
    }
    @Bean
    public String defaultName() {
        return "Default Name";
    }
}
