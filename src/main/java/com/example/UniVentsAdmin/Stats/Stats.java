package com.example.UniVentsAdmin.Stats;

import com.example.UniVentsAdmin.User.User;
import com.example.UniVentsAdmin.Event.Event;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "stats_users",
            joinColumns = @JoinColumn(name = "stats_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "stats_events",
            joinColumns = @JoinColumn(name = "stats_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", users=" + users +
                ", events=" + events +
                '}';
    }

}
