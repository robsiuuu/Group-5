package com.univents_customer.service;

import com.univents_customer.model.Event;
import com.univents_customer.model.Review;
import com.univents_customer.model.User;
import com.univents_customer.model.repository.EventRepository;
import com.univents_customer.model.repository.ReviewRepository;
import com.univents_customer.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public String submitReview(Long userId, Long eventId, int rating, String comment) {
        if (rating < 1 || rating > 5) {
            return "Invalid rating";
        }

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return "User not found";
        }

        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isEmpty()) {
            return "Event not found";
        }

        Review review = new Review(user.get(), event.get(), rating, comment);
        reviewRepository.save(review);
        return "Success:" + review.getId();
    }
}
