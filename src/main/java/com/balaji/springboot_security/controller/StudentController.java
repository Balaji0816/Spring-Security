package com.balaji.springboot_security.controller;

import com.balaji.springboot_security.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> students(){
        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("balaji");
        student1.setLastName("Maddipati");

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("vara");
        student2.setLastName("Maddipati");

        students.add(student1);
        students.add(student2);

        return students;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
