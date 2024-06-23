package com.example.springProject.student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(ModelMap modelMap) {
        List<Student> students = studentService.getStudents();
        modelMap.addAttribute("students", students);
        return "studentsList"; // Changed to avoid conflict
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        studentService.addStudent(student);
        return ResponseEntity.ok().body("Student added successfully");
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") int studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
