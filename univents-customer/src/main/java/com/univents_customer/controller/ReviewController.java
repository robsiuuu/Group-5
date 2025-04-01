package com.univents_customer.controller;

import com.univents_customer.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> submitReview(@RequestBody Map<String, Object> request) {
        Long userId = ((Number) request.get("userId")).longValue();
        Long eventId = ((Number) request.get("eventId")).longValue();
        int rating = (int) request.get("rating");
        String comment = (String) request.get("comment");

        String result = reviewService.submitReview(userId, eventId, rating, comment);

        switch (result) {
            case "User not found":
                return ResponseEntity.badRequest().body(Map.of("message", "User not found"));
            case "Event not found":
                return ResponseEntity.badRequest().body(Map.of("message", "Event not found"));
            case "Invalid rating":
                return ResponseEntity.badRequest().body(Map.of("message", "Rating must be between 1 and 5"));
            default:
                String[] parts = result.split(":");
                return ResponseEntity.ok(Map.of(
                        "message", "Review submitted!",
                        "reviewId", Long.parseLong(parts[1])
                ));
        }
    }
}
