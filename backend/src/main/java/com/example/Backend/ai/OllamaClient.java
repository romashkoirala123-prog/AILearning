package com.example.Backend.ai;

import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class OllamaClient {
    private final OllamaChatModel ollamaChatModel;
    private final VectorStore vectorStore;

    public OllamaClient(OllamaChatModel ollamaChatModel, VectorStore vectorStore) {
        this.ollamaChatModel =ollamaChatModel;
        this.vectorStore = vectorStore;
    }

    @PostMapping
    public String postMessage(@RequestBody String message) {
        return ChatClient.builder(ollamaChatModel)
                .build()
                .prompt()
                .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .user(message)
                .call()
                .content();
    }



}
