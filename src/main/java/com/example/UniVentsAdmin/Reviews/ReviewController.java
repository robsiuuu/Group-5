package com.example.UniVentsAdmin.Reviews;


import com.example.UniVentsAdmin.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private EventService eventService;

    @GetMapping("/user/{userId}")
    public Object getReviewsForUser(@PathVariable int userId)
    {
        return reviewService.getReviewsForUser(userId);

    }

    @PostMapping("/create/{eventId}")
    public Object postReview(@PathVariable int eventId, @RequestBody Review review)
    {
        reviewService.addNewReview(review, eventId);
        return new ResponseEntity<>("Review Posted!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reviewId}")
    public Object deleteReviewById(@PathVariable int reviewId) {
        reviewService.deleteReviewById(reviewId);
        return new ResponseEntity<>("Review deleted successfully.", HttpStatus.OK);
    }





}
