package uni_vents.com.univents_backend.Events;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import uni_vents.com.univents_backend.Reviews.Review;
import uni_vents.com.univents_backend.Statistics.Statistic;
import uni_vents.com.univents_backend.Users.User;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @DateTimeFormat(pattern = "HH:mm")
    private Date eventTime;

    @Column(nullable = false)
    private String eventLocation;

    @OneToMany
    @JsonManagedReference("event-statistic")
    private List<Statistic> statistics;

    @OneToMany
    @JsonManagedReference("event-review")
    private List<Review> reviews;


    private String eventDescription;



    public Event(int eventId, String eventName, Date eventDate, Date eventTime, String eventLocation) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;

    }

    public Event(String eventName, Date eventDate, Date eventTime, String eventLocation) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;


    }

    public Event(User creator, String eventName, Date eventDate, Date eventTime, String eventLocation) {
        this.creator = creator;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
    }

    public Event(){

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public String getEventDescription() {return eventDescription;}

    public void setEventDescription(String eventDescription) {this.eventDescription = eventDescription;}

    @Override
    public String toString(){
        return "Event{" +
                "eventId=" + eventId +
                "creator=" + creator +
                "eventName=" + eventName +
                "eventDate=" + eventDate +
                "eventTime=" + eventTime +
                "eventLocation=" + eventLocation +
                '}';

    }

}
