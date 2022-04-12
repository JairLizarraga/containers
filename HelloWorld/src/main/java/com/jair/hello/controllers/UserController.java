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

    @GetMapping("/api/user")
    public List<User> index(){
        return userRespository.findAll();
    }

    @GetMapping("/api/user/{id}")
    public Optional<User> show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userRespository.findById(userId);
    }
    
    @PostMapping(value="/api/user/")
    public User create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String password = body.get("password");
        return userRespository.save(new User(name, password));
    }

    @PutMapping("/api/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(id);

        User user = userRespository.findById(userId).get();
        user.setName(body.get("name"));
        user.setPassword(body.get("password"));
        return userRespository.save(user);
    }
    

}