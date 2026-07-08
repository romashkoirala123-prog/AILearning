
package com.example.Backend.repository;

import com.example.Backend.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuizRepository extends MongoRepository<Quiz,String> {
    List<Quiz> findByUserId(String id);
    List<Quiz> findByidandDocumentId(String name);
    List<Quiz> findByUserIdAndCompletedAtIsNull(String userId);
}
