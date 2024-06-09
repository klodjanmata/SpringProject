package com.example.springProject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") int studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId, name, email);

    }

}
