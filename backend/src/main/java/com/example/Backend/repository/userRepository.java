package com.example.Backend.repository;

import com.example.Backend.model.SUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface userRepository extends MongoRepository<SUser,Long> {
    Optional<SUser>  findByUsername(String username);
    List<SUser>  findByEmail(String email);
}
