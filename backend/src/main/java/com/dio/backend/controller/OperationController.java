package com.dio.backend.controller;

import com.dio.backend.model.Operation;
import com.dio.backend.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationService operationService;

    @PostMapping
    public Operation createOperation(@RequestBody Operation operation){
        return operationService.save(operation);
    }

    @GetMapping
    public List<Operation> getOperationList(){
        return operationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operation>  getOperationById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(operationService.findById(id).orElseThrow(()->new Exception("operation not found")));
    }

    @PutMapping
    public Operation updateOperation(@RequestBody Operation operation){
        return operationService.update(operation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Operation> deleteOperation(@PathVariable("id") Long id) {
        operationService.deleteOperation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
