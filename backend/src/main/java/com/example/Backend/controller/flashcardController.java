package com.example.Backend.controller;

import com.example.Backend.model.Flashcard;
import com.example.Backend.services.FlashcardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/flashcards")
@RequiredArgsConstructor
public class flashcardController {

    private final FlashcardService flashcardService;
    private final MongoTemplate mongoTemplate;


    @GetMapping
    public ResponseEntity<apiResponse<List<Flashcard>>> getAllSets(
            @AuthenticationPrincipal UserDetails user) {
        try {
            List<Flashcard> sets = flashcardService.getAllByUser(userId(user));
            return ResponseEntity.ok(apiResponse.ok(sets, "Flashcard sets fetched successfully"));
        } catch (Exception e) {
            log.error("getAllSets: {}", e.getMessage());
            return ResponseEntity.status(500).body(apiResponse.error(500, e.getMessage()));
        }
    }


    @GetMapping("/document/{documentId}")
    public ResponseEntity<apiResponse<Flashcard>> getByDocument(
            @PathVariable String documentId,
            @AuthenticationPrincipal UserDetails user) {
        try {
            Flashcard set = flashcardService.getByUserAndDocument(userId(user), documentId);
            return ResponseEntity.ok(apiResponse.ok(set, "Flashcard set fetched successfully"));
        } catch (RuntimeException e) {
            if (notFound(e)) return notFound404("Flashcard set not found");
            log.error("getByDocument: {}", e.getMessage());
            return ResponseEntity.status(500).body(apiResponse.error(500, e.getMessage()));
        }
    }


    @PostMapping("/document/{documentId}/cards/{cardIndex}/review")
    public ResponseEntity<apiResponse<Flashcard>> reviewCard(
            @PathVariable String documentId,
            @PathVariable int cardIndex,
            @AuthenticationPrincipal UserDetails user) {
        try {
            String uid = userId(user);
            Flashcard set = flashcardService.getByUserAndDocument(uid, documentId);

            if (cardIndex < 0 || cardIndex >= set.getCards().size())
                return bad400("cardIndex out of range");

            Query query = new Query(
                    Criteria.where("userId").is(uid).and("documentId").is(documentId));
            Update update = new Update()
                    .inc("cards." + cardIndex + ".reviewCount", 1)
                    .set("cards." + cardIndex + ".lastReviewed", LocalDateTime.now());
            mongoTemplate.updateFirst(query, update, Flashcard.class);

            Flashcard updated = flashcardService.getByUserAndDocument(uid, documentId);
            return ResponseEntity.ok(apiResponse.ok(updated, "Card reviewed successfully"));
        } catch (RuntimeException e) {
            if (notFound(e)) return notFound404("Flashcard set not found");
            log.error("reviewCard: {}", e.getMessage());
            return ResponseEntity.status(500).body(apiResponse.error(500, e.getMessage()));
        }
    }


    @PutMapping("/document/{documentId}/cards/{cardIndex}/star")
    public ResponseEntity<apiResponse<Flashcard>> toggleStar(
            @PathVariable String documentId,
            @PathVariable int cardIndex,
            @AuthenticationPrincipal UserDetails user) {
        try {
            String uid = userId(user);
            Flashcard set = flashcardService.getByUserAndDocument(uid, documentId);

            if (cardIndex < 0 || cardIndex >= set.getCards().size())
                return bad400("cardIndex out of range");

            boolean currentlyStarred = Boolean.TRUE.equals(
                    set.getCards().get(cardIndex).getIsStarred());
            boolean newStarred = !currentlyStarred;

            Flashcard updated = flashcardService.getByUserAndDocument(uid, documentId);
            String msg = newStarred ? "Card starred successfully" : "Card unstarred successfully";
            return ResponseEntity.ok(apiResponse.ok(updated, msg));
        } catch (RuntimeException e) {
            if (notFound(e)) return notFound404("Flashcard set not found");
            log.error("toggleStar: {}", e.getMessage());
            return ResponseEntity.status(500).body(apiResponse.error(500, e.getMessage()));
        }
    }

    @DeleteMapping("/document/{documentId}")
    public ResponseEntity<apiResponse<Void>> deleteSet(
            @PathVariable String documentId,
            @AuthenticationPrincipal UserDetails user) {
        try {
            String uid = userId(user);
            // Verify it exists first (so we return 404 instead of silently doing nothing)
            flashcardService.getByUserAndDocument(uid, documentId);
            flashcardService.delete(uid, documentId);
            return ResponseEntity.ok(apiResponse.ok(null, "Flashcard set deleted successfully"));
        } catch (RuntimeException e) {
            if (notFound(e)) return notFound404("Flashcard set not found");
            log.error("deleteSet: {}", e.getMessage());
            return ResponseEntity.status(500).body(apiResponse.error(500, e.getMessage()));
        }
    }

    private String userId(UserDetails u) { return u.getUsername(); }

    private boolean notFound(RuntimeException e) {
        return e.getMessage() != null && e.getMessage().contains("not found");
    }

    private <T> ResponseEntity<apiResponse<T>> notFound404(String msg) {
        return ResponseEntity.status(404).body(apiResponse.error(404, msg));
    }

    private <T> ResponseEntity<apiResponse<T>> bad400(String msg) {
        return ResponseEntity.status(400).body(apiResponse.error(400, msg));
    }
}