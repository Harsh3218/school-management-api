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

        Optional<Student> student1 = studentRepo.findById(Math.toIntExact(id));
        if (student1.isEmpty()) {
            throw new NotFoundException("Student not found with id: " + id);
        }
        Student student2 = student1.get();
        if(student2.getFirstName() != null && !student2.getFirstName().isEmpty()){
            student2.setFirstName(student.getFirstName());
        }
        if(student2.getLastName() != null && !student2.getLastName().isEmpty()){
            student2.setLastName(student.getLastName());
        }
        if (student2.getAge() != null){
            student2.setAge(student.getAge());
        }
        if(student2.getFatherName() != null && !student2.getFatherName().isEmpty()){
            student2.setFatherName(student.getFatherName());
        }
        if (student2.getMotherName() != null && !student2.getMotherName().isEmpty()){
            student2.setMotherName(student.getMotherName());
        }

        studentRepo.save(student2);
        return student2;
    }


    @Override
    public String deleteStudent(Long id) {

        Optional<Student> student1 = studentRepo.findById(Math.toIntExact(id));
        if (student1.isEmpty()) {
            throw new NotFoundException("Student not found with id: " + id);
        }
        studentRepo.deleteById(Math.toIntExact(id));
        return "Student deleted successfully";
    }
}
