package com.dio.backend.controller;

import com.dio.backend.model.AnnualLeave;
import com.dio.backend.service.AnnualLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annualleave")
public class AnnualLeaveController {

    @Autowired
    AnnualLeaveService annualLeaveService;

    @PostMapping
    public AnnualLeave createAnnualLeave(@RequestBody AnnualLeave annualLeave){
        return annualLeaveService.save(annualLeave);
    }

    @GetMapping
    public List<AnnualLeave> getAnnualLeaveList(){
        return annualLeaveService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnualLeave>  getAnnualLeaveById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(annualLeaveService.findById(id).orElseThrow(()->new Exception("Annualleave not found")));
    }

    @PutMapping
    public AnnualLeave updateAnnualLeave(@RequestBody AnnualLeave annualLeave){
        return annualLeaveService.update(annualLeave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnnualLeave> deleteAnnualLeave(@PathVariable("id") Long id) {
        annualLeaveService.deleteAnnualLeave(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
