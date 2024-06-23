package com.example.springProject.subject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {}
}
