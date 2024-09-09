package com.example.FresherManager.services.impl;

import com.example.FresherManager.dto.CreateAssignmentRequest;
import com.example.FresherManager.dto.CreateFresherRequest;
import com.example.FresherManager.models.Center;
import com.example.FresherManager.models.Fresher;
import com.example.FresherManager.repositories.CenterRepository;
import com.example.FresherManager.repositories.FresherRepository;
import com.example.FresherManager.services.FresherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FresherServiceImpl implements FresherService {
    private final FresherRepository fresherRepository;

    private final CenterRepository centerRepository;
    public FresherServiceImpl(FresherRepository fresherRepository, CenterRepository centerRepository) {
        this.fresherRepository = fresherRepository;
        this.centerRepository = centerRepository;
    }

    @Override
    public Fresher getById(Long id) {
        Optional<Fresher> fresherOptional = fresherRepository.findById(id);

        return fresherOptional.orElse(null);
    }

    @Override
    public Fresher save(CreateFresherRequest dto) {
        Fresher fresher = new Fresher();
        fresher.setName(dto.getName());
        fresher.setEmailFresher(dto.getEmailFresher());
        fresher.setProgramingLanguage(dto.getProgramingLanguage());
        return fresherRepository.save(fresher);
    }



    @Override
    public Fresher findById(Long id) {
        return fresherRepository.findById(id).orElse(null);

    }

    @Override
    public void deleteById(Long id) {
        fresherRepository.deleteById(id);
    }

    @Override
    public List<Fresher> getAllFresher() {
        return fresherRepository.findAll();
    }

    @Override
    public List<Fresher> searchFreshersByName(String name) {
        List<Fresher> response = new ArrayList<>();
        List<Fresher> freshers = fresherRepository.findAll();
        for (Fresher fresher : freshers) {
            if (fresher.getName().toLowerCase().contains(name.toLowerCase())) {
                response.add(fresher);
            }
        }

        return response;
    }

    @Override
    public List<Fresher> searchFreshersByEmailFresher(String emailFresher) {
        List<Fresher> response = new ArrayList<>();
        List<Fresher> freshers = fresherRepository.findAll();
        for (Fresher fresher : freshers) {
            if (fresher.getEmailFresher().toLowerCase().contains(emailFresher.toLowerCase())) {
                response.add(fresher);
            }
        }
        return response;
    }

    @Override
    public List<Fresher> searchFreshersByLanguage(String programingLanguage) {
        List<Fresher> response = new ArrayList<>();
        List<Fresher> freshers = fresherRepository.findAll();
        for (Fresher fresher : freshers) {
            if (fresher.getProgramingLanguage().toLowerCase().contains(programingLanguage.toLowerCase())) {
                response.add(fresher);
            }
        }
        return response;
    }

    @Override
    public Fresher saveFresher(Fresher updatedFresher) {
        return fresherRepository.save(updatedFresher);
    }


    @Override
    public CreateFresherRequest getFresherWithAverageScores(Long id) {
        Fresher fresher = fresherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fresher not found"));

        // Create Assignmentdto
        List<CreateAssignmentRequest> assignmentDtos = fresher.getAssignments().stream().map(assignment -> {
            CreateAssignmentRequest dto1 = new CreateAssignmentRequest();
            dto1.setId(assignment.getId());
          dto1.setName(assignment.getName());
            dto1.setScore1(assignment.getScore1());
           dto1.setScore2(assignment.getScore2());
            dto1.setScore3(assignment.getScore3());
            dto1.setAverageScore(assignment.calculateAverageScore());
            return dto1;
        }).collect(Collectors.toList());

        // Create Fresherdto
        CreateFresherRequest dto2 = new CreateFresherRequest();
        dto2.setId(fresher.getId());
        dto2.setName(fresher.getName());
        dto2.setEmailFresher(fresher.getEmailFresher());
        dto2.setProgramingLanguage(fresher.getProgramingLanguage());
        dto2.setAssignments(assignmentDtos);
        return dto2;
    }

    @Override
    public Fresher addFresherToCenter(Long fresherId, Long centerId) {
        Fresher fresher = fresherRepository.findById(fresherId)
                .orElseThrow(() -> new RuntimeException("Fresher not found"));

        Center center = centerRepository.findById(centerId)
                .orElseThrow(() -> new RuntimeException("Center not found"));

        fresher.setCenter(center);
        return fresherRepository.save(fresher);
    }


}
