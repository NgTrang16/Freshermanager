package com.example.FresherManager.controllers;

import com.example.FresherManager.dto.CreateFresherRequest;
import com.example.FresherManager.models.Fresher;
import com.example.FresherManager.services.FresherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("api/fresher")
public class FresherController {
    private  final Logger log = LoggerFactory.getLogger(FresherController.class);
    private final FresherService fresherService;

    public FresherController(FresherService fresherService) {
        this.fresherService = fresherService;
    }

    @GetMapping
    public ResponseEntity<List<Fresher>> getAllFreshers() {
        return ResponseEntity.ok(fresherService.getAllFresher());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fresher> getFresherById(@PathVariable("id") Long id) {
          return ResponseEntity.ok(fresherService.getById(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<Fresher> createFresherById(@RequestBody CreateFresherRequest dto) {
        return ResponseEntity.ok(fresherService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fresher> updateFresherById(@PathVariable("id") Long id, @RequestBody CreateFresherRequest dto) {
        Optional<Fresher> fresher = Optional.ofNullable(fresherService.findById(id));
        if(fresher.isPresent()) {
            Fresher updatedFresher = fresher.get();
            updatedFresher.setName(dto.getName());
            updatedFresher.setEmailFresher(dto.getEmailFresher());
            updatedFresher.setProgramingLanguage(dto.getProgramingLanguage());
            return ResponseEntity.ok(fresherService.saveFresher(updatedFresher));
        }else {
            dto.setId(id);
            return ResponseEntity.ok(fresherService.save(dto));
        }
    }
    @DeleteMapping("/{id}")
    public void deleteFresherById(@PathVariable("id") Long id) {
        fresherService.deleteById(id);
    }
    // search by name
    @GetMapping("/search/name")
    public ResponseEntity<List<Fresher>> searchFreshersByName(@RequestParam("name") String name, @RequestParam("id") String id) {
        log.info(id);
        List<Fresher> freshers = fresherService.searchFreshersByName(name);
        if (freshers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(freshers, HttpStatus.OK);
    }
     // search by email
    @GetMapping("/search/email")
    public ResponseEntity<List<Fresher>> searchFreshersByEmailFresher(@RequestParam("emailFresher") String emailFresher) {
        log.info(emailFresher);
        List<Fresher> freshers= fresherService.searchFreshersByEmailFresher(emailFresher);
        if (freshers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(freshers, HttpStatus.OK);
    }

    // search by programingLanguage
    @GetMapping("/search/language")
    public ResponseEntity<List<Fresher>> searchFreshersByProgramingLanguage(@RequestParam("language") String programingLanguage) {
        log.info(programingLanguage);
        List<Fresher> freshers = fresherService.searchFreshersByLanguage(programingLanguage);
        if (freshers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(freshers, HttpStatus.OK);
    }

//get score by id
    @GetMapping("/{id}/details")
    public ResponseEntity<CreateFresherRequest> getFresherDetails(@PathVariable Long id) {
        CreateFresherRequest dto = fresherService.getFresherWithAverageScores(id);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{fresherId}/center/{centerId}")
    public ResponseEntity<Fresher> addFresherToCenter(@PathVariable Long fresherId, @PathVariable Long centerId) {
        Fresher updatedFresher = fresherService.addFresherToCenter(fresherId, centerId);
        return ResponseEntity.ok(updatedFresher);
    }



}








