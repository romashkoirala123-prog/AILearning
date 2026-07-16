package com.example.Backend.services;

import com.example.Backend.model.SUser;
import com.example.Backend.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

    @Service
    @RequiredArgsConstructor
    public class UserService implements UserDetailsService {

        private final userRepository userRepo;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            SUser user = userRepo.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("No user found with email: " + email));

            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .authorities(Collections.emptyList())
                    .build();
        }
    }


