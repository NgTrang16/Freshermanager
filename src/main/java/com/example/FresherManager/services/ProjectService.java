package com.example.FresherManager.services;

import com.example.FresherManager.dto.BulkCreateProjectRequest;
import com.example.FresherManager.dto.CreateProjectRequest;
import com.example.FresherManager.models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();

    Project findById(Long id);

    List<Project> findByName(String name);

    Project save(CreateProjectRequest projects);

    void deleteById(Long id);

    List<Project> bulkCreteProject(BulkCreateProjectRequest dto);


    Project saveProject(Project updatedProject);
}
