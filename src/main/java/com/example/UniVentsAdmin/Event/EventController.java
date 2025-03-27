package com.example.UniVentsAdmin.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // get all events
    @GetMapping("/all")
    public Object getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    // Delete an event by ID
    @DeleteMapping("/ban/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") int eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }

}
