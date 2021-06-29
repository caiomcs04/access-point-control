package com.dio.backend.controller;

import com.dio.backend.model.Company;
import com.dio.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company){
        return companyService.save(company);
    }

    @GetMapping
    public List<Company> getCompanyList(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company>  getCompanyById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(companyService.findById(id).orElseThrow(()->new Exception("Company not found")));
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company){
        return companyService.update(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
