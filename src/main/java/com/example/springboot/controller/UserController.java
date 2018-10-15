package com.example.springboot.controller;

import com.example.springboot.models.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id) {
        return userRepository.findOne(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") String  id,
                       @RequestBody User user) {
        User user1 = userRepository.findOne(id);
        if(user.getAbout() != null) {
            user1.setAbout(user.getAbout());
        }

        if(user.getCreated() != null) {
            user1.setCreated(user.getCreated());
        }

        if(user.getDelay() != null) {
            user1.setDelay(user.getDelay());
        }

        if(user.getKarma() != null) {
            user1.setKarma(user.getKarma());
        }
        if(user.getSubmitted() != null) {
            user1.setSubmitted(user.getSubmitted());
        }

        return userRepository.save(user1);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        userRepository.delete(id);
        return "deleted user with id: " + id;
    }



}

