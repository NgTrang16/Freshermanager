package com.example.FresherManager.dto;

import com.example.FresherManager.models.Assignment;

import java.util.List;

public class CreateFresherRequest {
        private Long id;
        private String name;
        private String emailFresher;
        private String programingLanguage;
        private List<CreateAssignmentRequest> assignments;

    public CreateFresherRequest(List<CreateAssignmentRequest> assignments) {
        this.assignments = assignments;
    }

    public List<CreateAssignmentRequest> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<CreateAssignmentRequest> assignments) {
        this.assignments = assignments;
    }

    public CreateFresherRequest(String emailFresher, Long id, String name, String programingLanguage) {
        this.emailFresher = emailFresher;
        this.id = id;
        this.name = name;
        this.programingLanguage = programingLanguage;
    }

    public CreateFresherRequest() {
    }

    public String getEmailFresher() {
        return emailFresher;
    }

    public void setEmailFresher(String emailFresher) {
        this.emailFresher = emailFresher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }
}
