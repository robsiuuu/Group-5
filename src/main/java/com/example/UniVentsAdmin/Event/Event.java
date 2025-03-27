package com.example.UniVentsAdmin.Event;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creatorId;
    private int eventId;

    @Column(nullable = false)
    private String username;
    private String eventName;
    private String eventLocation;
    private String eventGenre;

    @Column(nullable = false)
    Date eventDate = new Date();
    Date eventTime = new Date();

    // Constructors
    public Event(int creatorId, int eventId, String username, String eventName, String eventLocation, String eventGenre, Date eventDate, Date eventTime) {
        this.creatorId = creatorId;
        this.eventId = eventId;
        this.username = username;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventGenre = eventGenre;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }

    public Event(){
    }

    // getters and setters
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
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

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "creatorId=" + creatorId +
                ", eventId=" + eventId +
                ", username='" + username + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventGenre='" + eventGenre + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                '}';
    }

}
