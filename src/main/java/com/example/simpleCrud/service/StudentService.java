package com.example.simpleCrud.service;

import com.example.simpleCrud.entity.Student;
import com.example.simpleCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    //public void addNewStudent(Student student){
        //studentRepository.findStudentByEmail(student.getEmail());

    //}
}
