package com.dio.backend.controller;

import com.dio.backend.model.UserCategory;
import com.dio.backend.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usercategory")
public class UserCategoryController {

    @Autowired
    UserCategoryService userCategoryService;

    @PostMapping
    public UserCategory createUserCategory(@RequestBody UserCategory userCategory){
        return userCategoryService.save(userCategory);
    }

    @GetMapping
    public List<UserCategory> getUserCategoryList(){
        return userCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCategory>  getUserCategoryById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(userCategoryService.findById(id).orElseThrow(()->new Exception("UserCategory not found")));
    }

    @PutMapping
    public UserCategory updateUserCategory(@RequestBody UserCategory userCategory){
        return userCategoryService.update(userCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserCategory> deleteUserCategory(@PathVariable("id") Long id) {
        userCategoryService.deleteUserCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
