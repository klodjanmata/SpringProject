package com.example.springProject.grade;

import com.example.springProject.professor.Professor;
import com.example.springProject.professor.ProfessorRepository;
import com.example.springProject.student.Student;
import com.example.springProject.student.StudentRepository;
import com.example.springProject.subject.Subject;
import com.example.springProject.subject.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Optional;

@Configuration
public class GradeConfig {

    @Bean
    CommandLineRunner commandLineRunnerGrade(GradeRepository gradeRepository, StudentRepository studentRepository, ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        return args -> {
            Optional<Student> studentOptional = studentRepository.findById(1);
            Optional<Professor> professorOptional = professorRepository.findById(1);
            Optional<Subject> subjectOptional = subjectRepository.findById(1);

            if (studentOptional.isPresent() && professorOptional.isPresent() && subjectOptional.isPresent()) {
                Student student = studentOptional.get();
                Professor professor = professorOptional.get();
                Subject subject = subjectOptional.get();

                Grade grade = new Grade();
                grade.setStudent(student);
                grade.setProfessor(professor);
                grade.setSubject(subject);
                grade.setGrade(4.5f);
                grade.setDate(LocalDate.now());

                gradeRepository.save(grade);
            } else {
                System.out.println("One of the entities (Student, Professor, Subject) is not present.");
            }
        };
    }
}
