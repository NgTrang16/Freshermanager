package com.example.FresherManager.controllers;

import com.example.FresherManager.dto.BulkCreateAssignmentRequest;
import com.example.FresherManager.dto.CreateAssignmentRequest;
import com.example.FresherManager.models.Assignment;
import com.example.FresherManager.services.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable(name = "id") Long id, @RequestBody CreateAssignmentRequest dto) {
        Optional<Assignment> assignment = assignmentService.findById(id);
        if (assignment.isPresent()) {
            Assignment Updatedassign = assignment.get();
            Updatedassign.setName(dto.getName());
            Updatedassign.setScore1(dto.getScore1());
            Updatedassign.setScore2(dto.getScore2());
            Updatedassign.setScore3(dto.getScore3());
            return ResponseEntity.ok(assignmentService.save(Updatedassign));
        }
        return ResponseEntity.ok(assignmentService.save(dto));
    }




@PostMapping("/insert")
    public Assignment createAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        boolean exists = assignmentService.findById(id).isPresent();
        if(exists) {
            return null;
        }
        return  assignmentService.save(assignment);
    }

    @PostMapping("/bulk")
    ResponseEntity<List<Assignment>> bulkCreateAssignment(@RequestBody BulkCreateAssignmentRequest dto) {
        return ResponseEntity.ok(assignmentService.bulkCreateAssignment(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        Optional<Assignment> assignment = assignmentService.findById(id);
        if (assignment.isPresent()) {
            assignmentService.deleteAssignment(id);
        }
    }




}
