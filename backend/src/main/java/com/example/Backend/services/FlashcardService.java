package com.example.Backend.services;

import com.example.Backend.model.Flashcard;
import com.example.Backend.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;
    private final MongoTemplate mongoTemplate;

    public Flashcard createFlashcard(String userId, String documentId, List<Flashcard.Card> cards) {
        Flashcard flashcard = Flashcard.builder()
                .userId(userId)
                .documentId(documentId)
                .cards(cards)
                .build();
        return flashcardRepository.save(flashcard);
    }

    public Flashcard getByUserAndDocument(String userId, String documentId) {
        return flashcardRepository.findByUserIdAndDocumentId(userId, documentId)
                .orElseThrow(() -> new RuntimeException("Flashcard not found"));
    }

    public List<Flashcard> getAllByUser(String userId) {
        return flashcardRepository.findByUserId(userId);
    }

    public Flashcard updateCards(String userId, String documentId, List<Flashcard.Card> cards) {
        Flashcard flashcard = getByUserAndDocument(userId, documentId);
        flashcard.setCards(cards);
        return flashcardRepository.save(flashcard);
    }

    public void delete(String userId, String documentId) {
        flashcardRepository.deleteByUserIdAndDocumentId(userId, documentId);
    }
}