package com.example.FresherManager.services;

import com.example.FresherManager.models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();

    Project findById(Long id);

    List<Project> findByName();

    Project save(Project projects);

    void deleteById(Long id);
}
