package com.example.Backend.services;

import com.example.Backend.model.SUser;
import com.example.Backend.repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final userRepository userRepo;

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SUser user=userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .authorities(Collections.emptyList())
                    .build();

    }
}


