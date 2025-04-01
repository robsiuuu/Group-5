package com.example.UniVentsAdmin.Review;

import com.example.UniVentsAdmin.User.User;
import com.example.UniVentsAdmin.Event.Event; // Import Event
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates reviewId
    private int reviewId;

    private int rating; // Stores the 1-5 rating
    private String comment;

    @ManyToOne
    @JoinColumn(name = "reviewerId", nullable = false)
    private User reviewer; // References the User who made the review

    @ManyToOne
    @JoinColumn(name = "eventId", nullable = false)
    private Event event; // References the Event being reviewed

    // Constructors
    public Review() {}

    public Review(int reviewId, int rating, String comment, User reviewer, Event event) {
        this.reviewId = reviewId;
        this.comment = comment;
        this.rating = rating;
        this.reviewer = reviewer;
        this.event = event;
    }

    // Getters and setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewer=" + reviewer +
                ", event=" + event +
                '}';
    }

}
