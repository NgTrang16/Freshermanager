package com.example.FresherManager.services.impl;

import com.example.FresherManager.models.Project;
import com.example.FresherManager.repositories.ProjectRepository;
import com.example.FresherManager.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> findByName() {
        List<Project> projects = projectRepository.findAll();
        List<Project> filteredProjects = new ArrayList<>();
        for (Project project : projects) {
            if (project.getName().toLowerCase().contains(project.getName().toLowerCase())) {
                filteredProjects.add(project);
            }
        }
        return filteredProjects;
    }

    @Override
    public Project save(Project projects) {
        return projectRepository.save(projects);
    }

    @Override
    public void deleteById(Long id) {
         projectRepository.deleteById(id);
    }

}
