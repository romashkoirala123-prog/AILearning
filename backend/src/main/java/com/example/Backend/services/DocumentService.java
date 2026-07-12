/*package com.example.Backend.services;

import com.example.Backend.model.Document;
import com.example.Backend.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor

public class DocumentService {
    private final DocumentRepository documentRepository;
    private final MongoTemplate mongoTemplate;


    public Document uploadAndProcess(String userId, String title, String fileUrl, MultipartFile file){
        Document document = Document.builder()
                .userID(userId)
                .title(title)
                .fileName(file.getOriginalFilename())
                .status("Processing")
                .build();
        document=documentRepository.save(document);
        return document;

    }
}
*/