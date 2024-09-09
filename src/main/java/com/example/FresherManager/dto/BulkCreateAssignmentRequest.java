package com.example.FresherManager.dto;

import java.util.List;

public class BulkCreateAssignmentRequest {
    private List<CreateAssignmentRequest> assignments;

    public BulkCreateAssignmentRequest() {
    }

    public BulkCreateAssignmentRequest(List<CreateAssignmentRequest> assignments) {
        this.assignments = assignments;
    }

    public List<CreateAssignmentRequest> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<CreateAssignmentRequest> assignments) {
        this.assignments = assignments;
    }
}
