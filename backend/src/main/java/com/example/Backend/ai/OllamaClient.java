package com.example.Backend.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:11434")
public class OllamaClient {
    private final ChatClient chatClient;

    public OllamaClient(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai/chat")
    public String generate(@RequestParam(value = "msg", defaultValue = "Tell me a joke") String message) {
        return this.chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
