package com.example.springProject.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalArgumentException("Student already exists");
        }
        studentRepository.save(student);
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found")
        );
    }

    public void deleteStudent(int studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalArgumentException("Student does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(int studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalArgumentException("Student does not exist. Cannot update")
        );
        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalArgumentException("Student with email: \"" + email + "\" already exists");
            }
            student.setEmail(email);
        }
    }
}
