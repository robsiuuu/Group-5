package uni_vents.com.univents_backend.Reviews;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import uni_vents.com.univents_backend.Events.Event;
import uni_vents.com.univents_backend.Replies.Reply;
import uni_vents.com.univents_backend.Users.User;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String reviewContent;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private Date reviewDate;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    @JsonBackReference("event-review")
    private Event event;


    public Review(User user, String reviewContent, int rating, Date reviewDate) {
        this.user = user;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }

    public Review() {}

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}