package com.example.FresherManager.controllers;

import com.example.FresherManager.models.Fresher;
import com.example.FresherManager.services.FresherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Fresher> createFresherById(@RequestBody Fresher fresher) {
        return ResponseEntity.ok(fresherService.save(fresher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fresher> updateFresherById(@PathVariable("id") Long id, @RequestBody Fresher newFresher) {
        Optional<Fresher> fresher = Optional.ofNullable(fresherService.findById(id));
        if(fresher.isPresent()) {
            Fresher updatedFresher = fresher.get();
            updatedFresher.setName(newFresher.getName());
            updatedFresher.setEmailFresher(newFresher.getEmailFresher());
            updatedFresher.setProgramingLanguage(newFresher.getProgramingLanguage());
            return ResponseEntity.ok(fresherService.save(updatedFresher));
        }else {
            newFresher.setId(id);
            return ResponseEntity.ok(fresherService.save(newFresher));
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
    @GetMapping("/searchs")
    public ResponseEntity<List<Fresher>> searchFreshersByProgramingLanguage(@RequestParam("language") String programingLanguage) {
        log.info(programingLanguage);
        List<Fresher> freshers = fresherService.searchFreshersByLanguage(programingLanguage);
        if (freshers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(freshers, HttpStatus.OK);
    }





}








