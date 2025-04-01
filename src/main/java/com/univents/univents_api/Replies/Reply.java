package com.univents.univents_api.Replies;

import com.univents.univents_api.Reviews.Review;
import com.univents.univents_api.Users.User;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "replies")
public class Reply {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyId;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;  // Each reply is tied to a review

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private User user;  // Reply is made by a provider

    @Column(nullable = false)
    private String replyContent;

    @Column(nullable = false)
    private Date replyDate;


    public Reply(Review review, User user, String replyContent, Date replyDate) {
        this.review = review;
        this.user = user;
        this.replyContent = replyContent;
        this.replyDate = replyDate;
    }

    public Reply() {}

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

}
