package com.example.Backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Flashcard")
@Getter @Setter
public class Flashcard {
    private String id;
    private String documentId;


}
