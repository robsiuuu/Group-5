package com.example.UniVentsAdmin.Replies;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies")
public class ReplyController {


    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> postReply(@RequestBody Reply reply) {
        try {
            int reviewId = reply.getReview().getReviewId();
            replyService.addNewReply(reply, reviewId);
            return new ResponseEntity<>("Reply posted successfully!", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<List<Reply>> getRepliesForReview(@PathVariable int reviewId) {
        try {
            List<Reply> replies = replyService.getRepliesForReview(reviewId);
            return new ResponseEntity<>(replies, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

