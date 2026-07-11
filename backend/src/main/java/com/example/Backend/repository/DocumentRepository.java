package com.example.Backend.repository;

import com.example.Backend.model.Document;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends MongoRepository<Document,String> {
    List<Document> findByUserId(String id);
    List<Document> findByUserNameAndUserId(String userName, String id);
    boolean existsByUserIdAndUserId(String userId,String id);
}
