package com.example.Backend.repository;

import com.example.Backend.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz,String> {
}
