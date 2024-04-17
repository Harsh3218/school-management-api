package com.example.schoolManagement.service.impl;

import com.example.schoolManagement.DTO.TeacherDTO;
import com.example.schoolManagement.entity.Teacher;
import com.example.schoolManagement.exception.NotFoundException;
import com.example.schoolManagement.repository.ParentRepo;
import com.example.schoolManagement.repository.TeacherRepo;
import com.example.schoolManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String save(Teacher teacher) {
        teacherRepo.save(teacher);
        return "Teacher saved successfully";
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepo.findById(id)
                .orElseThrow(()-> new NotFoundException("Teacher not found with id: " + id));
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher update(Long id, Teacher teacher) {
        teacher.setId(id);
        return teacherRepo.save(teacher);
    }

    @Override
    public String delete(Long id) {
        Optional<Teacher> teacher = teacherRepo.findById(id);
        if (teacher.isPresent()) {
            teacherRepo.deleteById(id);
        } else {
            throw new NotFoundException("Teacher not found with id: " + id);
        }
        return null;
    }
}
