package com.example.FresherManager.services.impl;

import com.example.FresherManager.dto.BulkCreateAssignmentRequest;
import com.example.FresherManager.dto.CreateAssignmentRequest;
import com.example.FresherManager.dto.CreateProjectRequest;
import com.example.FresherManager.models.Assignment;
import com.example.FresherManager.models.Project;
import com.example.FresherManager.repositories.AssignmentRepository;
import com.example.FresherManager.services.AssignmentService;
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

    @Override
    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public List<Assignment> bulkCreateAssignment(BulkCreateAssignmentRequest dto) {
        List<Assignment> assignments = new ArrayList<>();
        List<CreateAssignmentRequest> assignmentRequests = dto.getAssignments();
        for (CreateAssignmentRequest assignmentRequest : assignmentRequests) {
            Assignment assignment = new Assignment();
            assignment.setId(assignmentRequest.getId());
            assignment.setName(assignmentRequest.getName());
            assignment.setScore1(assignmentRequest.getScore1());
            assignment.setScore2(assignmentRequest.getScore2());
            assignment.setScore3(assignmentRequest.getScore3());
            assignments.add(assignment);
        }
        return assignmentRepository.saveAll(assignments);
    }

    @Override
    public Assignment save(CreateAssignmentRequest dto) {
       Assignment assignment = new Assignment();
       assignment.setName(dto.getName());
       assignment.setScore1(dto.getScore1());
       assignment.setScore2(dto.getScore2());
       assignment.setScore3(dto.getScore3());
       return assignmentRepository.save(assignment);
    }


}
