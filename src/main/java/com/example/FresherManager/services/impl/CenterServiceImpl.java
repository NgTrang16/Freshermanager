package com.example.FresherManager.services.impl;

import com.example.FresherManager.models.Center;
import com.example.FresherManager.repositories.CenterRepository;
import com.example.FresherManager.services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {
    private final CenterRepository  centerRepository;
    @Autowired
    public CenterServiceImpl(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }


    @Override
    public List<Center> findAll() {
        return centerRepository.findAll();
    }

    @Override
    public Center findById(Long id) {
        return centerRepository.findById(id).orElse(null);
    }

    @Override
    public Center save(Center center) {
        return centerRepository.save(center);
    }

    @Override
    public void deleteById(Long id) {
        centerRepository.deleteById(id);
    }


}
