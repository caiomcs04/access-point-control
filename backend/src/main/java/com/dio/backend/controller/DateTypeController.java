package com.dio.backend.controller;

import com.dio.backend.model.DateType;
import com.dio.backend.service.DateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/datetype")
public class DateTypeController {

    @Autowired
    DateTypeService dateTypeService;

    @PostMapping
    public DateType createDateType(@RequestBody DateType dateType){
        return dateTypeService.save(dateType);
    }

    @GetMapping
    public List<DateType> getDateTypeList(){
        return dateTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DateType>  getDateTypeById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(dateTypeService.findById(id).orElseThrow(()->new Exception("Date Type not found")));
    }

    @PutMapping
    public DateType updateDateType(@RequestBody DateType dateType){
        return dateTypeService.update(dateType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DateType> deleteDateType(@PathVariable("id") Long id) {
        dateTypeService.deleteDateType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
