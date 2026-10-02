package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List < User > getUsers() {
    	System.out.println("Get all Users...");
    	
    	List<User> list = new ArrayList<>();
        Iterable<User> customers = userRepository.findAll();
        
        customers.forEach(list::add);
        return list;
    }
    
    @PostMapping("/users/create")
    public User createUser(@Validated @RequestBody User user) {
      System.out.println("Create User: " + user.getFirstName() + "...");
   
      return userRepository.save(user);
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
      System.out.println("Get User by id...");
   
      java.util.Optional<User> userData = userRepository.findById(id);
      if (userData.isPresent()) {
        return new ResponseEntity<>(userData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
   
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
      System.out.println("Update User with ID = " + id + "...");
   
      java.util.Optional<User> userData = userRepository.findById(id);
      if (userData.isPresent()) {
        User savedUser = userData.get();
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setEmail(user.getEmail());
        
   
        User updatedUser = userRepository.save(savedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
   
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
      System.out.println("Delete User with ID = " + id + "...");
   
      try {
        userRepository.deleteById(id);
      } catch (Exception e) {
        return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
      }
   
      return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }
}