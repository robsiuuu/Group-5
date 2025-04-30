package com.univents_customer.controller;

import com.univents_customer.model.Event;
import com.univents_customer.model.Subscription;
import com.univents_customer.model.User;
import com.univents_customer.model.repository.SubscriptionRepository;
import com.univents_customer.model.repository.UserRepository;
import com.univents_customer.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

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

    // Get events a user is subscribed to
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Event>> getUserSubscribedEvents(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<Subscription> subscriptions = subscriptionRepository.findAll();
        List<Event> events = new ArrayList<>();

        for (Subscription sub : subscriptions) {
            if (sub.getUser().getId().equals(userId)) {
                events.add(sub.getEvent());
            }
        }

        return ResponseEntity.ok(events);
    }
}
