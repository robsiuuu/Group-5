package com.example.UniVentsAdmin.Stats;

import com.example.UniVentsAdmin.Event.Event;
import com.example.UniVentsAdmin.User.User;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statsId;

    @ManyToOne
    @JoinColumn(name = "eventId", nullable = false)
    private Event event; // References the Event being reviewed

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String statsTitle;
    private String statsDescription;
    private int statsData;
    private Date createdAt = new Date();
    private Date updatedDate = new Date();

    // constructors
    public Stats() {
    }

    public Stats(int statsId, Event event, User user, String statsTitle, String statsDescription, int statsData, Date createdAt, Date updatedDate) {
        this.statsId = statsId;
        this.event = event;
        this.user = user;
        this.statsTitle = statsTitle;
        this.statsDescription = statsDescription;
        this.statsData = statsData;
        this.createdAt = createdAt;
        this.updatedDate = updatedDate;
    }

    // getters and setters
    public int getStatsId() {
        return statsId;
    }

    public void setStatsId(int statsId) {
        this.statsId = statsId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatsTitle() {
        return statsTitle;
    }

    public void setStatsTitle(String statsTitle) {
        this.statsTitle = statsTitle;
    }

    public String getStatsDescription() {
        return statsDescription;
    }

    public void setStatsDescription(String statsDescription) {
        this.statsDescription = statsDescription;
    }

    public int getStatsData() {
        return statsData;
    }

    public void setStatsData(int statsData) {
        this.statsData = statsData;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "statsId=" + statsId +
                ", event=" + event +
                ", user=" + user +
                ", statsTitle='" + statsTitle + '\'' +
                ", statsDescription='" + statsDescription + '\'' +
                ", statsData=" + statsData +
                ", createdAt=" + createdAt +
                ", updatedDate=" + updatedDate +
                '}';
    }

}
