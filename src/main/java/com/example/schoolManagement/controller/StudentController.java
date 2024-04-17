package com.example.schoolManagement.controller;

import com.example.schoolManagement.entity.Student;
import com.example.schoolManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student Data Added Successfully";
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById((long) id);
    }

    
}
