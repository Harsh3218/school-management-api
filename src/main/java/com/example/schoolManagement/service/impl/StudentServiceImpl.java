package com.example.schoolManagement.service.impl;

import com.example.schoolManagement.DTO.StudentDTO;
import com.example.schoolManagement.entity.Parent;
import com.example.schoolManagement.entity.Student;
import com.example.schoolManagement.exception.NotFoundException;
import com.example.schoolManagement.repository.ParentRepo;
import com.example.schoolManagement.repository.StudentRepo;
import com.example.schoolManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ParentRepo parentRepo;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {

        Optional<Parent> optionalParent = parentRepo.findById(studentDTO.getParentId());
        Parent parent = optionalParent.orElseThrow(() -> new NotFoundException("Parent not found with id: " + studentDTO.getParentId()));


        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        student.setParent(parent);


        Student savedStudent = studentRepo.save(student);


        return convertToDTO(savedStudent);
    }
    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(Math.toIntExact(id));
        Student student = optionalStudent.orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
        return convertToDTO(student);
    }


    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        // Find the existing student by ID
        Optional<Student> optionalStudent = studentRepo.findById(Math.toIntExact(id));
        Student existingStudent = optionalStudent.orElseThrow(() -> new NotFoundException("Student not found with id: " + id));

        // Update student details from DTO
        existingStudent.setFirstName(studentDTO.getFirstName());
        existingStudent.setLastName(studentDTO.getLastName());
        existingStudent.setAge(studentDTO.getAge());


        if (studentDTO.getParentId() != null) {

            Optional<Parent> optionalParent = parentRepo.findById(studentDTO.getParentId());
            if (optionalParent.isPresent()) {

                existingStudent.setParent(optionalParent.get());
            } else {
                throw new NotFoundException("Parent not found with id: " + studentDTO.getParentId());
            }
        } else {

            existingStudent.setParent(null);
        }


        Student updatedStudent = studentRepo.save(existingStudent);


        return convertToDTO(updatedStudent);
    }


    @Override
    public String deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(Math.toIntExact(id));
        Student student = optionalStudent.orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
        studentRepo.deleteById(Math.toIntExact(id));
        return "Student deleted successfully";
    }


    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());

        if (student.getParent() != null) {
            studentDTO.setParentId(student.getParent().getId());
            studentDTO.setParentFirstName(student.getParent().getFirstName());
            studentDTO.setParentLastName(student.getParent().getLastName());
        }

        return studentDTO;
    }

}
