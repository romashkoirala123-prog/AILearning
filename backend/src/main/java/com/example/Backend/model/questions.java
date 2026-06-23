package com.example.Backend.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class questions {
    @NotBlank
    private String question;
    @NotBlank
    private String answer;
    @Builder.Default
    private String explanation="";
}
