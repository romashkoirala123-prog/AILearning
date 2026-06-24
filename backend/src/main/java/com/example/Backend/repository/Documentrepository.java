package com.example.Backend.repository;

import com.example.Backend.model.document;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Documentrepository extends MongoRepository<document,String> {
    List<document> findByUserId(String id);
    List<document> findByUserNameAndUserId(String userName, String id);
    boolean existsByUserIdAndUserId(String userId,String id);
}
