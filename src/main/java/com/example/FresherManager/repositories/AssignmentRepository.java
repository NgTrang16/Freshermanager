package com.example.FresherManager.repositories;

import com.example.FresherManager.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    String existsByName(String name);
}
