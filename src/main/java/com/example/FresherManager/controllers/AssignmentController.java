package com.example.FresherManager.controllers;

import com.example.FresherManager.models.Assignment;
import com.example.FresherManager.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }
    @GetMapping("")
    public List<Assignment> getAllAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/{id}")
    public Assignment getAssignmentById(@PathVariable Long id) {
        Optional<Assignment> assignment = assignmentService.findById(id);
        if (assignment.isPresent()) {
            return assignment.get();
        }
        return null;
    }

}
