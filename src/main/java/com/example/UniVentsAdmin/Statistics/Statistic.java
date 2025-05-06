package com.example.UniVentsAdmin.Statistics;

import com.example.UniVentsAdmin.Event.Event;
import com.example.UniVentsAdmin.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "statistics")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statisticId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonBackReference("event-statistic")
    private Event event;

    private String statisticTitle;

    private String statisticDescription;

    private int statisticData;

    @Temporal(TemporalType.TIMESTAMP)
    private Date statisticCreatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date statisticUpdatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user-statistic")
    private User user;


    public Statistic(Event event, String statisticTitle, String statisticDescription, int statisticData, Date statisticCreatedAt, Date statisticUpdatedAt, User user) {
        this.event = event;
        this.statisticTitle = statisticTitle;
        this.statisticDescription = statisticDescription;
        this.statisticData = statisticData;
        this.statisticCreatedAt = statisticCreatedAt;
        this.statisticUpdatedAt = statisticUpdatedAt;
        this.user = user;
    }

    public Statistic(){}

    public int getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(int statisticId) {
        this.statisticId = statisticId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getStatisticTitle() {
        return statisticTitle;
    }

    public void setStatisticTitle(String statisticTitle) {
        this.statisticTitle = statisticTitle;
    }

    public String getStatisticDescription() {
        return statisticDescription;
    }

    public void setStatisticDescription(String statisticDescription) {
        this.statisticDescription = statisticDescription;
    }

    public int getStatisticData() {
        return statisticData;
    }

    public void setStatisticData(int statisticData) {
        this.statisticData = statisticData;
    }

    public Date getStatisticCreatedAt() {
        return statisticCreatedAt;
    }

    public void setStatisticCreatedAt(Date statisticCreatedAt) {
        this.statisticCreatedAt = statisticCreatedAt;
    }

    public Date getStatisticUpdatedAt() {
        return statisticUpdatedAt;
    }

    public void setStatisticUpdatedAt(Date statisticUpdatedAt) {
        this.statisticUpdatedAt = statisticUpdatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Statistics{" +
                "StatisticId=" + statisticId +
                ", Event='" + event + '\'' +
                ", StatisticTitle='" + statisticTitle + '\'' +
                ", StatisticDescription='" + statisticDescription + '\'' +
                ", StatisticData='" + statisticData + '\'' +
                ", StatisticCreatedAt='" + statisticCreatedAt + '\'' +
                ", StatisticUpdatedAt=" + statisticUpdatedAt + '\'' +
                ", User='" + user +
                '}';
    }

}
