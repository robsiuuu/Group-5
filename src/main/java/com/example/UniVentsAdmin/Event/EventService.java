package com.example.UniVentsAdmin.Event;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // ban an event by id
    public void deleteEvent(int eventId) {
        eventRepository.deleteById(eventId);
    }

}
