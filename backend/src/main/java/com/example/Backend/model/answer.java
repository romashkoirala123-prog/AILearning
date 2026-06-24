package com.example.Backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class answer {
    @NotNull
    private Integer questionIndex;
    @NotNull
    private Boolean isCorrect;
    @NotBlank
    private String selectedAnswer;
    @Builder.Default
    private LocalDateTime answeredAt = LocalDateTime.now();
    @Builder.Default
    private Difficulty difficulty = Difficulty.MEDIUM;
}

