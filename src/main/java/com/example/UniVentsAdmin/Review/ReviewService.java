package com.example.UniVentsAdmin.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // ban a review by id
    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
