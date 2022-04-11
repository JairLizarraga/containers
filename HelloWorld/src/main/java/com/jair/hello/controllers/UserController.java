package com.jair.hello.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jair.hello.models.User;
import com.jair.hello.resources.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRespository;

    @GetMapping("/user")
    public List<User> index(){
        return userRespository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userRespository.findById(userId);
    }



}