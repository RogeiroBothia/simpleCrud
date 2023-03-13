package com.example.simpleCrud.service;

import com.example.simpleCrud.entity.Student;
import com.example.simpleCrud.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public void addNewStudent(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long id,
                              String name,
                              String email) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Student with id "+ id+ "does not exist"));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)){

            student.setName(name);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)){

            student.setEmail(email);
        }
    }

    public void deleteStudent(Long id){
        boolean exist = studentRepository.existsById(id);
        if(!exist) {
            throw new IllegalMonitorStateException(
                    "Student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }
}
