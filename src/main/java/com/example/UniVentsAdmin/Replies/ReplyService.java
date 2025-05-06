package com.example.UniVentsAdmin.Replies;


import com.example.UniVentsAdmin.Reviews.Review;
import com.example.UniVentsAdmin.Reviews.ReviewRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {


    private final ReplyRepository replyRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository, ReviewRepository reviewRepository) {
        this.replyRepository = replyRepository;
        this.reviewRepository = reviewRepository;
    }

    public void addNewReply(Reply reply, int reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);

        if (reviewOptional.isEmpty()) {
            throw new RuntimeException("Review not found with ID: " + reviewId);
        }

        reply.setReview(reviewOptional.get());

        replyRepository.save(reply);
    }

    public List<Reply> getRepliesForReview(int reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);

        if (reviewOptional.isEmpty()) {
            throw new RuntimeException("Review not found with ID: " + reviewId);
        }

        return replyRepository.findByReview(reviewOptional.get());
    }

}
