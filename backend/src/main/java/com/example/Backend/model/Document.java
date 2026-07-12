package com.example.Backend.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@org.springframework.data.mongodb.core.mapping.Document(collection = "documents")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @id
    private String id;

    private String userID;
    private String title;
    private String fileName;
    private String filePath;
    private String fileSize;

    @Builder.Default
    private String status = "processing";
    private String extractedText;
    private LocalDateTime lastAccessed;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime lastModified;
}
