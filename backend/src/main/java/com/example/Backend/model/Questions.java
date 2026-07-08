package com.example.Backend.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Questions {
    @NotBlank
    private String question;
    @NotBlank
    private String correctAnswer;
    @Builder.Default
    private String explanation="";
    @Builder.Default
    private Difficulty difficulty = Difficulty.MEDIUM;
}
