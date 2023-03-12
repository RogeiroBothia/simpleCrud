package com.example.simpleCrud.repository;

import com.example.simpleCrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // SELECT * FROM students WHERE email = ?
    //@Query("SELECT s FROM Student s WHERE s.email = ?1")//s is alias of Student entity
    //Optional<Student> findStudentByEmail(String email);
}