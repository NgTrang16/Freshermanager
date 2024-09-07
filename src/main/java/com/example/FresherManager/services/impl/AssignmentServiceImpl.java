package com.example.FresherManager.services.impl;

import com.example.FresherManager.models.Assignment;
import com.example.FresherManager.repositories.AssignmentRepository;
import com.example.FresherManager.services.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AssignmentServiceImpl implements AssignmentService {
   public final AssignmentRepository assignmentRepository;
   public AssignmentServiceImpl(AssignmentRepository assignmentRepository) {
       this.assignmentRepository = assignmentRepository;
   }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Optional<Assignment> findById(Long id) {
        return assignmentRepository.findById(id);
    }

    @Override
    public List<Assignment> searchAssignmentByName(String name) {
        List<Assignment> assignments = new ArrayList<>();
        List<Assignment> allAssignments = assignmentRepository.findAll();
        for (Assignment assignment : allAssignments) {
            if (assignment.getName().toLowerCase().contains(name.toLowerCase())) {
                assignments.add(assignment);
            }
        }
        return assignments;
    }

}
