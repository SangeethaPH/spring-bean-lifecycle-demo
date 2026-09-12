package com.sangeetha.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sangeetha.lifecycle")
public class AppConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public ReportService reportService(MessageRepository messageRepository) {
        return new ReportService(messageRepository);
    }
}
