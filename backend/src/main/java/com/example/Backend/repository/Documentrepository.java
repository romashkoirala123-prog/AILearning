package com.example.Backend.repository;

import com.example.Backend.model.Doc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Documentrepository extends MongoRepository<Doc,String> {
    List<Doc> findByUserId(String id);
    List<Doc> findByUserNameAndUserId(String userName,String id);
    List<Doc> findByUserIdAndStatus(String userId, Doc.DocumentStatus status);
    boolean existsByUserIdAndUserId(String userId,String id);
}
