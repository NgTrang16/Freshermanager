package com.example.FresherManager.services;

import com.example.FresherManager.dto.CreateFresherRequest;
import com.example.FresherManager.models.Fresher;

import java.util.List;
import java.util.Map;

public interface FresherService {

    Fresher getById(Long id);

    Fresher save(CreateFresherRequest dto);

    Fresher findById(Long id);

    void deleteById(Long id);

    List<Fresher> getAllFresher();

    List<Fresher> searchFreshersByName(String name);

    List<Fresher> searchFreshersByEmailFresher(String emailFresher);

    List<Fresher> searchFreshersByLanguage(String programingLanguage);

    Fresher saveFresher(Fresher updatedFresher);

    CreateFresherRequest getFresherWithAverageScores(Long id);

    Fresher addFresherToCenter(Long fresherId, Long centerId);
}
