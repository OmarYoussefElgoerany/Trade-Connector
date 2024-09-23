package com.tradeconnector.company_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
public class AuditorConfig {

    @Bean
    public AuditorAware<Integer> auditorProvider() {
        // This is a mock implementation. In a real-world application, you would get the currently logged-in user's ID.
        return () -> Optional.of(1);  // Replace "1" with the logic to fetch the actual user ID
    }
}
