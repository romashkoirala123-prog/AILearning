package com.example.Backend.repository;

import com.example.Backend.model.SUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface userRepository extends MongoRepository<SUser,Long> {
    Optional<SUser>  findByUsername(String username);
    List<SUser> findAllByUserid(String id);
    List<SUser>  findByEmail(String email);
}
