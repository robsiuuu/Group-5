package com.example.UniVentsAdmin.Review;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    private int rating;
    private int reviewerId;

    // constructors
    public Review(int reviewId, int rating, int reviewerId) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewerId = reviewerId;
    }

    public Review(){
    }

    // getters and setters
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

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", reviewerId=" + reviewerId +
                '}';
    }

}
