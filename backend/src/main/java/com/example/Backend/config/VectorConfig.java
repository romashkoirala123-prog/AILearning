package com.example.Backend.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VectorConfig {
    /*
    * SimpleVectorStore is an in-memory dataabase provided by spring AI
    * it takes embedding model as every document is inserted in it  calculate the vectors
    * and stores them
    * */
    @Bean
    public VectorStore  vectorStore(EmbeddingModel embeddingModel) {
        return SimpleVectorStore.builder(embeddingModel).build();
    }
}
