package com.example.Backend.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
public class OllamaClient {
    private final ChatClient chatClient;

    public OllamaClient(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }



}
