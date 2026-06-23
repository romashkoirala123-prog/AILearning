package com.example.Backend.repository;

import com.example.Backend.model.ChatHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatHistoryrepository extends MongoRepository<ChatHistory,String> {
}
