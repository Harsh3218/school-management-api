package com.example.schoolManagement.service.impl;

import com.example.schoolManagement.entity.Student;
import com.example.schoolManagement.exception.NotFoundException;
import com.example.schoolManagement.repository.StudentRepo;
import com.example.schoolManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepo.findById(Math.toIntExact(id));
        return student.orElseThrow(()-> new NotFoundException("Student not found with id: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {
        return false;
    }
}
