package com.example.Backend.ai;

import com.example.Backend.model.Flashcard;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashcardGenService {

    private final ChatClient chatClient;

    public FlashcardGenService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public List<Flashcard.Card> generateCards(String context, int count) {

            return this.chatClient.prompt()
                    .user(u -> u.text("""
                            You are an educational assistant. Extract key concepts from the text below and generate {count} flashcards.
                            
                            Text: "{context}"
                            
                            For each item in the array, provide:
                            - "question": A concise question.
                            - "answer": The correct answer.
                            - "difficulty": One of the following exact string values: "EASY", "MEDIUM", or "HIGH".
                            """)
                            .param("count", String.valueOf(count))
                            .param("context", context))
                    .call()
                    .entity(new ParameterizedTypeReference<List<Flashcard.Card>>() {});
                    }
}