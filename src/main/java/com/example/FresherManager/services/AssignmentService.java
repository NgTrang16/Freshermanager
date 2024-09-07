package com.example.FresherManager.services;

import com.example.FresherManager.models.Assignment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> findAll();

    Optional<Assignment> findById(Long id);

    List<Assignment> searchAssignmentByName(String name);

}
