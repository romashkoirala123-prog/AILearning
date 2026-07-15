package com.example.Backend.ai;

import com.example.Backend.repository.QuizRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.data.mongodb.core.MongoTemplate;

public class QuizGenService {
    private final VectorStore   vectorStore;
    private final ChatClient    chatClient;

    public QuizGenService(VectorStore vectorStore, QuizRepository quizRepository, ChatClient.Builder chatClient, MongoTemplate mongoTemplate) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClient.build();
    }


}
