package com.example.schoolManagement.controller;

import com.example.schoolManagement.entity.Teacher;
import com.example.schoolManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public String createTeacher(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
        return "Teacher added successfully";
    }

    @GetMapping()
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.update(id, teacher);
    }

    @DeleteMapping("{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.delete(id);
        return "Teacher Deleted";
    }
}
