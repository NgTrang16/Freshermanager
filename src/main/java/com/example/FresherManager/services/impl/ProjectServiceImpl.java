package com.example.FresherManager.services.impl;

import com.example.FresherManager.dto.BulkCreateProjectRequest;
import com.example.FresherManager.dto.CreateProjectRequest;
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
    public List<Project> findByName(String name) {
        List<Project> projects = projectRepository.findAll();
        List<Project>  projects1 = new ArrayList<>();
        for (Project project : projects) {
            if (project.getName().toLowerCase().contains(name.toLowerCase())) {
                projects1.add(project);
            }
        }
        return projects1;
    }

    @Override
    public Project save(CreateProjectRequest dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setManager(dto.getManager());
        project.setProgramingLanguage(dto.getProgramingLanguage());
        project.setStatus(dto.getStatus());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());

        return projectRepository.save(project);
    }

    @Override
    public void deleteById(Long id) {
         projectRepository.deleteById(id);
    }

    @Override
    public List<Project> bulkCreteProject(BulkCreateProjectRequest dto) {
        List<Project> projects = new ArrayList<>();
        List<CreateProjectRequest> projectRequests = dto.getProjects();

        for (CreateProjectRequest projectRequest : projectRequests) {
            Project project = new Project();
            project.setName(projectRequest.getName());
            project.setManager(projectRequest.getManager());
            project.setProgramingLanguage(projectRequest.getProgramingLanguage());
            project.setStatus(projectRequest.getStatus());
            project.setStartDate(projectRequest.getStartDate());
            project.setEndDate(projectRequest.getEndDate());
            projects.add(project);
        }

        return projectRepository.saveAll(projects);
    }

    @Override
    public Project saveProject(Project updatedProject) {
        return projectRepository.save(updatedProject);
    }

}
