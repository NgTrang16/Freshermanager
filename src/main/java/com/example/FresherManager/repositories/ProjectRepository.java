package com.example.FresherManager.repositories;

import com.example.FresherManager.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
