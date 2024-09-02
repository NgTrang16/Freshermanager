package com.example.FresherManager.services;

import com.example.FresherManager.models.Center;

import java.util.List;

public interface CenterService {

    List<Center> findAll();

    Center findById(Long id);

    Center save(Center center);

    void deleteById(Long id);


    List<Center> searchFreshersByName(String name);
}
