package com.example.Backend.ai;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentIngestionService implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DocumentIngestionService.class);
    private static final String Document_id = "Chemistry-XII-2077";
    @Value("classpath:/documents/Chemistry-XII-2077-full-book.pdf")
    private Resource resource;
    private final VectorStore vectorStore;

    @Override
    public void run(String... args) {
        PagePdfDocumentReader pdfDocumentReader = new PagePdfDocumentReader(resource);
        log.info("Processing PDF file");
        TextSplitter textSplitter= TokenTextSplitter.builder().build();
        vectorStore.accept(textSplitter.split(pdfDocumentReader.read()));
        log.info("Completed Processing PDF file");
    }
}
