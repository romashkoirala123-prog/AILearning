/*package com.example.Backend.repository;

import com.example.Backend.model.Document;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends MongoRepository<Document,String> {
    List<Document> findByUserId(String userId);
    List<Document> findByIdAndUserId(String userId, String id);
    List<Document> findByDocumentId(String documentId);
    boolean existsByUserIdAndDocumentId(String userId, String documentId);
    void deleteByIdAndUserId(String id, String userId);
}
*/