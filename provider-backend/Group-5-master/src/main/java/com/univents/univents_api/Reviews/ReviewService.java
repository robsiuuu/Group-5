package com.univents.univents_api.Reviews;

import com.univents.univents_api.Events.Event;
import com.univents.univents_api.Events.EventRepository;
import com.univents.univents_api.Replies.Reply;
import com.univents.univents_api.Replies.ReplyRepository;
import com.univents.univents_api.Users.User;
import com.univents.univents_api.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public Object getReviewsForUser(int userId) {
        return reviewRepository.findById(userId);
    }

    public void addNewReview(Review review, int eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Event with ID " + eventId + " does not exist.");
        }

        review.setEvent(eventOptional.get());
        reviewRepository.save(review);
    }
}
