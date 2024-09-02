package com.example.FresherManager.dto;

import java.util.List;

public class BulkCreateProjectRequest {
    private List<CreateProjectRequest> projects;

    public BulkCreateProjectRequest() {}

    public BulkCreateProjectRequest(List<CreateProjectRequest> projects) {
        this.projects = projects;
    }

    public List<CreateProjectRequest> getProjects() {
        return projects;
    }

    public void setProjects(List<CreateProjectRequest> projects) {
        this.projects = projects;
    }
}
