package com.example.FresherManager.controllers;

import com.example.FresherManager.models.Center;
import com.example.FresherManager.services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/center")
public class CenterController {
    private final CenterService centerService;
    @Autowired
    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @GetMapping
    public List<Center> getAllCenters() {
        return centerService.findAll();
    }

  @GetMapping("/{id}")
    public Center getCenterById(@PathVariable Long id) {
        return centerService.findById(id);
  }

  @PostMapping("/insert" )
    public Center insertCenter(@RequestBody Center center) {
        return  centerService.save(center);
  }

  @PutMapping("{id}")
    public ResponseEntity updateCenter(@PathVariable Long id, @RequestBody Center center) {
        Optional<Center> centers = Optional.ofNullable(centerService.findById(id));
        if (centers.isPresent()) {
            centers.get().setName(center.getName());
            centers.get().setAddress(center.getAddress());
            return ResponseEntity.ok(centerService.save(centers.get()));
        }
        return ResponseEntity.notFound().build();
  }
  @DeleteMapping("/{id}")
    public void deleteCenter(@PathVariable Long id) {
     Center center = centerService.findById(id);
     if (center != null) {
         centerService.deleteById(id);
     }
  }

}
