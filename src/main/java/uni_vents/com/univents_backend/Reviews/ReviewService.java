package uni_vents.com.univents_backend.Reviews;

import uni_vents.com.univents_backend.Events.Event;
import uni_vents.com.univents_backend.Events.EventRepository;
import uni_vents.com.univents_backend.Replies.Reply;
import uni_vents.com.univents_backend.Replies.ReplyRepository;
import uni_vents.com.univents_backend.Users.User;
import uni_vents.com.univents_backend.Users.UserRepository;
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

    public Object getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId);
    }


    public void addNewReview(Review review, int eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Event with ID " + eventId + " does not exist.");
        }

        review.setEvent(eventOptional.get());
        reviewRepository.save(review);
    }

    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
