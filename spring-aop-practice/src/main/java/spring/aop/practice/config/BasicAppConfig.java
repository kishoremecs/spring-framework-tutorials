package spring.aop.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicAppConfig {

    @Bean
    public String appName() {
        return "spring-aop-practice";
    }

}
