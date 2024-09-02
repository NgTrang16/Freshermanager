package com.example.FresherManager.repositories;

import com.example.FresherManager.models.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FresherRepository extends JpaRepository <Fresher, Long> {

    void deleteById(Long id);


}
