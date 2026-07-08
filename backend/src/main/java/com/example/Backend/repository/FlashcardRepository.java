package com.example.Backend.repository;

import com.example.Backend.model.Flashcard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends MongoRepository<Flashcard,String> {
}
