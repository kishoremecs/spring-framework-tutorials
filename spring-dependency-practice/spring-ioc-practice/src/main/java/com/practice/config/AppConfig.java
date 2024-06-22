package com.practice.config;

import com.practice.util.DynamicIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AppConfig {

    @Bean
    public LocalDate currentDate() {
        return LocalDate.now();
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public DynamicIdGenerator uniqueIdGenerator() {
        return new DynamicIdGenerator();
    }
}
