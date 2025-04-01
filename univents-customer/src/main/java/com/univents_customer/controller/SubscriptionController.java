package com.univents_customer.controller;

import com.univents_customer.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<?> subscribeToEvent(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long eventId = request.get("eventId");

        String result = subscriptionService.subscribeUserToEvent(userId, eventId);

        switch (result) {
            case "User not found":
                return ResponseEntity.badRequest().body(Map.of("message", "User not found"));
            case "Event not found":
                return ResponseEntity.badRequest().body(Map.of("message", "Event not found"));
            case "Already subscribed":
                return ResponseEntity.badRequest().body(Map.of("message", "User is already subscribed to this event"));
            case "Success":
                return ResponseEntity.ok(Map.of("message", "Subscription successful!"));
            default:
                return ResponseEntity.status(500).body(Map.of("message", "Unknown error"));
        }
    }

    @DeleteMapping
    public ResponseEntity<?> unsubscribeFromEvent(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long eventId = request.get("eventId");

        String result = subscriptionService.unsubscribeUserFromEvent(userId, eventId);

        switch (result) {
            case "User not found":
                return ResponseEntity.badRequest().body(Map.of("message", "User not found"));
            case "Event not found":
                return ResponseEntity.badRequest().body(Map.of("message", "Event not found"));
            case "Subscription not found":
                return ResponseEntity.badRequest().body(Map.of("message", "Subscription not found"));
            case "Unsubscribed":
                return ResponseEntity.ok(Map.of("message", "Unsubscribed successfully"));
            default:
                return ResponseEntity.status(500).body(Map.of("message", "Unknown error"));
        }
    }
}
