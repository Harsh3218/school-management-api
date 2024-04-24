package com.example.schoolManagement.service.impl;

import com.example.schoolManagement.entity.Parent;
import com.example.schoolManagement.exception.NotFoundException;
import com.example.schoolManagement.repository.ParentRepo;
import com.example.schoolManagement.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepo ParentRepo;

    @Override
    public Parent saveParent(Parent parent) {
        return ParentRepo.save(parent);
    }

    @Override
    public Parent getParentById(Long id) {
        return ParentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Parent not found with id: " + id));
    }

    @Override
    public List<Parent> getAllParents() {
        return ParentRepo.findAll();
    }

    @Override
    public Parent updateParent(Long id, Parent parent) {
        parent.setId(id); // Ensure the ID is set for update operation
        return ParentRepo.save(parent);
    }

    @Override
    public String deleteParent(Long id) {
         Optional<Parent> parentOptional = ParentRepo.findById(id);
         if (parentOptional.isPresent()) {
             ParentRepo.delete(parentOptional.get());
         } else {
             throw new NotFoundException("Parent not found with id: " + id);
         }
        return "Parent deleted successfully";
    }
}
