package com.example.Backend.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.Filter;
import org.springframework.ai.vectorstore.filter.FilterExpressionBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class OllamaClient {
    private final ChatClient chatClient;
    private final VectorStore vectorStore;
    public OllamaClient(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder.build();
        this.vectorStore = vectorStore;
    }

    @PostMapping
    public String postMessage(@RequestBody String message,
                              @RequestParam(required = false)String documentId) {
        QuestionAnswerAdvisor.Builder advisorBuilder=QuestionAnswerAdvisor.builder(vectorStore);
        if (documentId != null) {}
        return chatClient.prompt()
                .advisors(advisorBuilder.build())
                .user(message)
                .call()
                .content();
    }





}
