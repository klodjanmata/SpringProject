package com.example.springProject.subject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubjectConfig {

    @Bean
    CommandLineRunner commandLineRunnerSubject(SubjectRepository subjectRepository){
        return args -> {
            Subject maths = new Subject(1,"Maths","desc1",2);
            Subject chemistry = new Subject(2,"Chemistry","desc2",2);
            Subject geography = new Subject(3,"Geography","desc3",1);

            subjectRepository.saveAll(List.of(maths, chemistry, geography));
        };
    }
}