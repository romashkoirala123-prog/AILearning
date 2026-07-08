package com.example.Backend.services;

import com.example.Backend.model.Quiz;
import com.example.Backend.model.Questions;
import com.example.Backend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService
{
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Quiz createQuiz(String userId, String documentId,
                           String title, List<Questions> question) {
        Quiz quiz = Quiz.builder()
                .userId(userId)
                .documentId(documentId)
                .title(title)
                .question(question)
                .totalQuestions(question.size())
                .build();
        return quizRepository.save(quiz);
    }

}
