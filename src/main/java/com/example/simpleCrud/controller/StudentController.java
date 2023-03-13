package com.example.simpleCrud.controller;

import com.example.simpleCrud.entity.Student;
import com.example.simpleCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/api/students")
    public List<Student> showStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/api/student")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @PutMapping("/api/student/{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false)  String email){
        studentService.updateStudent(id, name, email);

    }

    @DeleteMapping("/api/student/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
}
