package com.example.FresherManager.controllers;

import com.example.FresherManager.models.Assignment;
import com.example.FresherManager.models.Fresher;
import com.example.FresherManager.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // search by name
    @GetMapping("/search/name")
    public ResponseEntity<List<Assignment>> searchAssignmentByName(@RequestParam String name) {
        List<Assignment> assignments = assignmentService.searchAssignmentByName(name);
        if(assignments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

//    @PostMapping("/insert")
//    public ResponseEntity<Assignment> insertAssignment(@RequestBody Assignment newAssignment) {
//        return assignmentService.save(newAssignment);
//    }


}
