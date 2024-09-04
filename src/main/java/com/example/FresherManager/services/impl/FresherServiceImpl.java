package com.example.FresherManager.services.impl;

import com.example.FresherManager.dto.CreateFresherRequest;
import com.example.FresherManager.models.Fresher;
import com.example.FresherManager.repositories.FresherRepository;
import com.example.FresherManager.services.FresherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FresherServiceImpl implements FresherService {
    private final FresherRepository fresherRepository;

    public FresherServiceImpl(FresherRepository fresherRepository) {
        this.fresherRepository = fresherRepository;
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


}
