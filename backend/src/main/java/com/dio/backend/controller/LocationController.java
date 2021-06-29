package com.dio.backend.controller;

import com.dio.backend.model.Location;
import com.dio.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationService.save(location);
    }

    @GetMapping
    public List<Location> getLocationList(){
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location>  getLocationById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(locationService.findById(id).orElseThrow(()->new Exception("Location not found")));
    }

    @PutMapping
    public Location updateOccurrence(@RequestBody Location location){
        return locationService.update(location);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteOccurrence(@PathVariable("id") Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
