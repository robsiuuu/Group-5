package com.univents.univents_api.Reviews;

import com.univents.univents_api.Events.Event;
import com.univents.univents_api.Events.EventService;
import com.univents.univents_api.Replies.Reply;
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
    public Object getReviewsForUser(@PathVariable int userId) {
        return reviewService.getReviewsForUser(userId);
    }






}
