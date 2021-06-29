package com.dio.backend.controller;

import com.dio.backend.model.AccessLevel;
import com.dio.backend.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/accesslevel")
public class AccessLevelController {

    @Autowired
    AccessLevelService accessLevelService;

    @PostMapping
    public AccessLevel createAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.save(accessLevel);
    }

    @GetMapping
    public List<AccessLevel> getAccessLevelList(){
        return accessLevelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessLevel>  getAccessLevelById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(accessLevelService.findById(id).orElseThrow(()->new Exception("AccessLevel not found")));
    }

    @PutMapping
    public AccessLevel updateAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.update(accessLevel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccessLevel> deleteDateType(@PathVariable("id") Long id) {
        accessLevelService.deleteAccessLevel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
