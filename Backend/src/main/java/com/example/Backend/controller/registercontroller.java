package com.example.Backend.controller;

import com.example.Backend.model.SUser;
import com.example.Backend.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class registercontroller {
    @Autowired
    private  userRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<SUser> registerUser(@RequestBody SUser user) {
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/home")
    public String yes(){return "registered";}
}
