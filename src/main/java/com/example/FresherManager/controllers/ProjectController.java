package com.example.FresherManager.controllers;

import com.example.FresherManager.dto.BulkCreateProjectRequest;
import com.example.FresherManager.dto.CreateProjectRequest;
import com.example.FresherManager.models.Fresher;
import com.example.FresherManager.models.Project;
import com.example.FresherManager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable(name = "id") Long id) {
        return projectService.findById(id) ;
    }

    @GetMapping("search/name")
    public List<Project> getProjectByName(@RequestParam (name = "name")String name) {
        List<Project> projects = projectService.findByName(name);
        if(projects.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return projects;
    }

    @PostMapping("/insert")
    Project insertProject(@RequestBody CreateProjectRequest dto) {
        return projectService.save(dto);
    }

    @PostMapping("/bulk")
    ResponseEntity<List<Project>> bulkCreteProject(@RequestBody BulkCreateProjectRequest dto) {
        return ResponseEntity.ok(projectService.bulkCreteProject(dto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(name = "id") Long id, @RequestBody CreateProjectRequest dto) {
        Optional<Project> project = Optional.ofNullable(projectService.findById(id));
        if(project.isPresent()) {
            Project updatedProject = project.get();
            updatedProject.setName(dto.getName());
            updatedProject.setManager(dto.getManager());
            updatedProject.setProgramingLanguage(dto.getProgramingLanguage());
            updatedProject.setStatus(dto.getStatus());
            updatedProject.setStartDate(dto.getStartDate());
            updatedProject.setEndDate(dto.getEndDate());
            return ResponseEntity.ok(projectService.saveProject(updatedProject));
        }
        return ResponseEntity.ok(projectService.save(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        Project project = projectService.findById(id);
        if (project != null) {
            projectService.deleteById(id);
        }
    }


}
