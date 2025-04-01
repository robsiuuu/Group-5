package com.univents.univents_api.Events;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.univents.univents_api.Reviews.Review;
import com.univents.univents_api.Statistics.Statistic;
import com.univents.univents_api.Users.User;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    @JsonManagedReference("event-creator")
    private User creator;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date eventTime;

    @Column(nullable = false)
    private String eventLocation;

    @OneToMany
    @JsonManagedReference("event-statistic")
    private List<Statistic> statistics;

    @OneToMany
    @JsonManagedReference("event-review")
    private List<Review> reviews;


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
