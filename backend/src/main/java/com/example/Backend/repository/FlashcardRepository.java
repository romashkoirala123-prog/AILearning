package com.example.Backend.repository;

import com.example.Backend.model.Flashcard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlashcardRepository extends MongoRepository<Flashcard,String> {
}
