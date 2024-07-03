package com.example.springProject.professor;

import com.example.springProject.subject.Subject;
import com.example.springProject.subject.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProfessorConfig {

    @Bean
    CommandLineRunner commandLineRunnerProfessor(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        return args -> {
            Subject maths = subjectRepository.findById(1).orElseThrow(() -> new IllegalArgumentException("Subject not found"));
            Subject chemistry = subjectRepository.findById(2).orElseThrow(() -> new IllegalArgumentException("Subject not found"));

            Professor professor1 = new Professor();
            professor1.setName("Prof. Smith");
            professor1.setEmail("smith@gmail.com");
            professor1.setSubjects(List.of(maths, chemistry));

            professorRepository.save(professor1);
        };
    }
}
