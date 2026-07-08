package com.example.Backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "quiz")
public class Quiz {
    @Id
    private String id;
    @NotNull
    private String userId;
    @NotNull
    private String documentId;
    @NotBlank
    private String title;
    @Builder.Default
    private List<Questions> question=new ArrayList<>();
    @Builder.Default
    private List<answer> answers = new ArrayList<>();
    @Builder.Default
    private Integer score = 0;

    @NotNull
    private Integer totalQuestions;

    @Builder.Default
    private LocalDateTime completedAt = null;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
