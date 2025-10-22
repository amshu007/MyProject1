package com.example.user.service.controller;


import com.example.user.service.entities.User;
import com.example.user.service.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User user1 = userService.saveUser(user);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> allUser = userService.getAllUser();

        return ResponseEntity.ok(allUser);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){

        User user = userService.getUser(userId);

        return ResponseEntity.ok(user);

    }
}
