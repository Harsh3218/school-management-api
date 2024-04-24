package com.example.schoolManagement.service;

import com.example.schoolManagement.entity.Parent;

import java.util.List;

public interface ParentService {

    Parent saveParent(Parent parent);

    Parent getParentById(Long id);

    List<Parent> getAllParents();

    Parent updateParent(Long id, Parent parent);

    String deleteParent(Long id);
}
