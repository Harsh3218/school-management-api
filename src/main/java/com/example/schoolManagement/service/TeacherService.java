package com.example.schoolManagement.service;

import com.example.schoolManagement.entity.Teacher;
import java.util.List;

public interface TeacherService {

    String save(Teacher teacher);

    Teacher getTeacherById(Long id);

    List<Teacher> findAll();

    Teacher update(Long id,Teacher teacher);

    String delete(Long id);
}
