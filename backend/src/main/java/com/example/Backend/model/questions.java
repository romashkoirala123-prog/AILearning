package com.example.Backend.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class questions {
    private String questions;
    private String options;
    private String answers;
    private String explanation;
    private String userAnswer;
    private String selectedAnswer;
    private int score;

    @Getter(AccessLevel.NONE)
    private boolean isCorrect;
    public boolean isCorrect() {
        if(this.answers == null || this.answers.isEmpty()) {
            return false;
        }
        return this.answers.trim().equalsIgnoreCase(this.userAnswer.trim());
    }

}
