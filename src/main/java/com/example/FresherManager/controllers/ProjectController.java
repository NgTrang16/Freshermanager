package com.example.FresherManager.controllers;

import com.example.FresherManager.models.Project;
import com.example.FresherManager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.findById(id) ;
    }

    @GetMapping("search/name")
    public List<Project> getProjectByName(@RequestParam String name) {
        List<Project> projects = projectService.findByName();
        if(projects.isEmpty()) {
            return null;
        }
        return projects;
    }

    @PostMapping("/insert")
    Project insertProject(@RequestBody Project project) {
        return projectService.save(project);
    }
//
//    @PutMapping("/{id}")
//    ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
//        Optional<Project> projects = Optional.ofNullable(projectService.findById(id));
//        if(projects.isPresent()) {
//            Project updatedProject = projects.get();
//            updatedProject.setName(project.getName());
//            updatedProject.setManager(project.getManager());
//            updatedProject.setProgramingLanguage(project.getProgramingLanguage());
//            updatedProject.setStartDate(project.getStartDate());
//            updatedProject.setEndDate(project.getEndDate());
//            updatedProject.setStatus(project.getStatus());
//            return ResponseEntity.ok(projectService.save(updatedProject));
//        }
//        else{
//            project.setId(id);
//            return ResponseEntity.ok(projectService.save(project));
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProject(@PathVariable Long id) {
//        Project project = projectService.findById(id);
//        if(project != null) {
//            projectService.deleteById(id);
//        }
//    }
//

}
