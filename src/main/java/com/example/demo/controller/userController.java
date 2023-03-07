package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.demo.Services.userService;
import com.example.demo.entity.User;


@RestController
public class userController {

    public userService services;
    
    @Autowired
    public userController(userService services){
        this.services = services;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return services.getUserList();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser = services.createUser(user);
        System.out.println(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    
}
