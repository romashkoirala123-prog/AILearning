package com.example.Backend.services;

import com.example.Backend.model.SUser;
import com.example.Backend.repository.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Userservice implements UserDetailsService {
    @Autowired
    private userRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SUser> user=userRepo.findByUsername(username);
        if(user.isPresent()){
            var Obj=user.get();
            return User.builder()
                    .username(Obj.getUsername())
                    .password(Obj.getPassword())
                    .build();
        }
        else{throw new UsernameNotFoundException(username);}
    }
}


