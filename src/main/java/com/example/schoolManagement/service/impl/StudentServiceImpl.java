package com.example.schoolManagement.service.impl;

import com.example.schoolManagement.DTO.StudentDTO;
import com.example.schoolManagement.entity.Parent;
import com.example.schoolManagement.entity.Student;
import com.example.schoolManagement.entity.Teacher;
import com.example.schoolManagement.exception.NotFoundException;
import com.example.schoolManagement.repository.ParentRepo;
import com.example.schoolManagement.repository.StudentRepo;
import com.example.schoolManagement.repository.TeacherRepo;
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

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String saveStudent(StudentDTO studentDTO) {

        Optional<Parent> optionalParent = parentRepo.findById(studentDTO.getParentId());
        Parent parent = optionalParent.orElseThrow(() -> new NotFoundException("Parent not found with id: " + studentDTO.getParentId()));

        Teacher teacher = null;
        if (studentDTO.getTeacherId() != null) {
            Optional<Teacher> optionalTeacher = teacherRepo.findById(studentDTO.getTeacherId());
            teacher = optionalTeacher.orElseThrow(() -> new NotFoundException("Teacher not found with id: " + studentDTO.getTeacherId()));
        }

        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setAge(studentDTO.getAge());
        student.setClassroom(studentDTO.getClassroom());
        student.setParent(parent);
        student.setTeacher(teacher);


        Student savedStudent = studentRepo.save(student);
        convertToDTO(savedStudent);
        return "Student saved successfully";
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

        Optional<Student> optionalStudent = studentRepo.findById(Math.toIntExact(id));
        Student existingStudent = optionalStudent.orElseThrow(() -> new NotFoundException("Student not found with id: " + id));


        existingStudent.setFirstName(studentDTO.getFirstName());
        existingStudent.setLastName(studentDTO.getLastName());
        existingStudent.setAge(studentDTO.getAge());
        existingStudent.setClassroom(studentDTO.getClassroom());

        // Find and set the parent associated with the student
        if (studentDTO.getParentId() != null) {
            Optional<Parent> optionalParent = parentRepo.findById(studentDTO.getParentId());
            Parent parent = optionalParent.orElseThrow(() -> new NotFoundException("Parent not found with id: " + studentDTO.getParentId()));
            existingStudent.setParent(parent);
        } else {
            existingStudent.setParent(null); // Clear parent association if parentId is null
        }

        // Assign teacher if teacherId is provided
        if (studentDTO.getTeacherId() != null) {
            Optional<Teacher> optionalTeacher = teacherRepo.findById(studentDTO.getTeacherId());
            Teacher teacher = optionalTeacher.orElseThrow(() -> new NotFoundException("Teacher not found with id: " + studentDTO.getTeacherId()));
            existingStudent.setTeacher(teacher);
        } else {
            existingStudent.setTeacher(null); // Clear teacher association if teacherId is null
        }

        // Save the updated student entity
        Student updatedStudent = studentRepo.save(existingStudent);

        // Convert the updated student entity to DTO and return
        return convertToDTO(updatedStudent);
    }


    @Override
    public String deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepo.findById(Math.toIntExact(id));
        Student student = optionalStudent.orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
        studentRepo.delete(student);
        return "Student deleted successfully";
    }


    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        studentDTO.setClassroom(student.getClassroom());


        Parent parent = student.getParent();
        if (parent != null) {
            studentDTO.setParentId(parent.getId());
            studentDTO.setParentFirstName(parent.getFirstName());
            studentDTO.setParentLastName(parent.getLastName());
        } else {

            studentDTO.setParentId(null);
            studentDTO.setParentFirstName("Unknown");
            studentDTO.setParentLastName("Unknown");
        }


        Teacher teacher = student.getTeacher();
        if (teacher != null) {
            studentDTO.setTeacherId(teacher.getId());
            studentDTO.setTeacherName(teacher.getName());
        } else {

            studentDTO.setTeacherId(null);
            studentDTO.setTeacherName("Not assigned");
        }

        return studentDTO;
    }

}
