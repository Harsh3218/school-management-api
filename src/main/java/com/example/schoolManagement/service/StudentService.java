package com.example.schoolManagement.service;

import com.example.schoolManagement.DTO.StudentDTO;
import com.example.schoolManagement.entity.Student;

import java.util.List;

public interface StudentService {

    String saveStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long id);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(Long id, StudentDTO studentDTO);

    String deleteStudent(Long id);
}
