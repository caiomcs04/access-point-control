package com.dio.backend.controller;

import com.dio.backend.model.Occurrence;
import com.dio.backend.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    @Autowired
    OccurrenceService occurrenceService;

    @PostMapping
    public Occurrence createOccurrence(@RequestBody Occurrence occurrence){
        return occurrenceService.save(occurrence);
    }

    @GetMapping
    public List<Occurrence> getOccurrenceList(){
        return occurrenceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Occurrence>  getOccurrenceById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(occurrenceService.findById(id).orElseThrow(()->new Exception("Occurrence not found")));
    }

    @PutMapping
    public Occurrence updateOccurrence(@RequestBody Occurrence occurrence){
        return occurrenceService.update(occurrence);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Occurrence> deleteOccurrence(@PathVariable("id") Long id) {
        occurrenceService.deleteOccurrence(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
