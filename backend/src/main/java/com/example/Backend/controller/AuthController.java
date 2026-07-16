package com.example.Backend.controller;

import com.example.Backend.model.SUser;
import com.example.Backend.repository.userRepository;
import com.example.Backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final userRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SUser user) {
        if(userRepo.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("User already exists");
        }
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);

        return ResponseEntity.ok("User Registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody SUser loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        String token=jwtUtil.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(Map.of("token", token)) ;
    }

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }
}
