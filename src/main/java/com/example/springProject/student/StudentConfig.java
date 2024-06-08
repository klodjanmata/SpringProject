package com.example.springProject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student klodjan = new Student("Klodjan", "klodjan@gmail.com",  LocalDate.of(2000, 5, 3));
            Student alban = new Student("Alban", "alban@gmail.com", LocalDate.of(1999, 3, 5));
            Student alex = new Student("Alex", "alex@gmail.com",  LocalDate.of(2001, 8, 24));

            studentRepository.saveAll(List.of(klodjan, alban, alex));
        };
    }
}
