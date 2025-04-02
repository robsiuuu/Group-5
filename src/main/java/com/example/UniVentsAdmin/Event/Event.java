package com.example.UniVentsAdmin.Event;

import com.example.UniVentsAdmin.User.User;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @ManyToOne
    @JoinColumn(name = "creatorId", nullable = false)
    @JsonIgnore // This prevents Jackson from serializing the full User object
    private User creator; // References the User who created the event

    @Column(nullable = false)
    private String eventName;
    private String eventLocation;
    private String eventGenre;

    @Column(nullable = false)
    private Date eventDate = new Date();

    // Constructors
    public Event(User creator, String eventName, String eventLocation, String eventGenre, Date eventDate) {
        this.creator = creator;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventGenre = eventGenre;
        this.eventDate = eventDate;
    }

    public Event() {
    }

    // Getters and setters
    @JsonProperty("creator")
    public String getCreatorUsername() {
        return creator != null ? creator.getUsername() : null;
    }

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
                ", eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventGenre='" + eventGenre + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }

}
