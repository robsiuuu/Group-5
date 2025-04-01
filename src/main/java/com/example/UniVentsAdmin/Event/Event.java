package com.example.UniVentsAdmin.Event;

import com.example.UniVentsAdmin.User.User;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @ManyToOne
    @JoinColumn(name = "creatorId", nullable = false)
    private User creator; // References the User who created the event

    @Column(nullable = false)
    private String username;
    private String eventName;
    private String eventLocation;
    private String eventGenre;

    @Column(nullable = false)
    private Date eventDate = new Date();

    // Constructors
    public Event(User creator, String username, String eventName, String eventLocation, String eventGenre, Date eventDate) {
        this.creator = creator;
        this.username = username;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventGenre = eventGenre;
        this.eventDate = eventDate;
    }

    public Event() {
    }

    // Getters and setters
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventGenre() {
        return eventGenre;
    }

    public void setEventGenre(String eventGenre) {
        this.eventGenre = eventGenre;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", creator=" + creator +
                ", username='" + username + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventGenre='" + eventGenre + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
