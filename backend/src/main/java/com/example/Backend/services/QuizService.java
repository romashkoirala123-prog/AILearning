package com.example.Backend.services;

import com.example.Backend.model.Quiz;
import com.example.Backend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class QuizService
{
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Quiz findById(String id,String documentId)
    {}

}
