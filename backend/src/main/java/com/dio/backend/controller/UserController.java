package com.dio.backend.controller;

import com.dio.backend.model.User;
import com.dio.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> getUserList(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>  getUserById(@PathVariable("id") Long id ) throws Exception {
        return ResponseEntity.ok(userService.findById(id).orElseThrow(()->new Exception("User not found")));
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
