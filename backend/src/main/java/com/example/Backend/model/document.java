package com.example.Backend.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="documents")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class document {
    private String id;
    private String documentId;
}
