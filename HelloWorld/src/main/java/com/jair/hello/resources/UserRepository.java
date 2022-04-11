package com.jair.hello.resources;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jair.hello.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // custom query to search to blog post by title or content
    //List<User> findByTitleContainingOrContentContaining(String text, String textAgain);    
}