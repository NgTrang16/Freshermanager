package com.example.FresherManager.services;

import com.example.FresherManager.dto.BulkCreateAssignmentRequest;
import com.example.FresherManager.models.Assignment;
import com.example.FresherManager.models.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AssignmentService {
    List<Assignment> findAll();

    Optional<Assignment> findById(Long id);

    List<Assignment> searchAssignmentByName(String name);

    Assignment save(Assignment assignment);

    void deleteAssignment(Long id);

    List<Assignment> bulkCreateAssignment(BulkCreateAssignmentRequest dto);


}
