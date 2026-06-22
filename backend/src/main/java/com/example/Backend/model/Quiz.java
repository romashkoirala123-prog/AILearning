package com.example.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "quiz")
@Getter @Setter
public class Quiz {
    @Id
    private String id;
    @DocumentReference(lazy = true)
    private String documentId;
    private String title;
    private List<questions> questions;
    private String difficulty;

}
