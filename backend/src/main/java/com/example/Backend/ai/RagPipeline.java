/*package com.example.Backend.ai;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RagPipeline {
    private final VectorStore vectorStore;

    @PostConstruct  //Auto start on startup
    public void runPipeline() {
        // reads documents: parses provided material which turns raw text into spring AI document object

        PagePdfDocumentReader pdfReader = new PagePdfDocumentReader("documents/Chemistry-XII-2077-full-book.pdf",PdfDocumentReaderConfig.defaultConfig());
        List<Document> extractedDocuments = pdfReader.read();

        //turns large chunks of data into smaller block of tokens i.e. large pdf-> text Chunks -> smaller text chunks
        TokenTextSplitter transformer = TokenTextSplitter.builder().build();
        List<Document> chunkedDocuments = transformer.apply(extractedDocuments);

        //it calls embedding model converts test chunks to vectors and stores
        vectorStore.accept(chunkedDocuments);
    }
}
*/