package com.univents.univents_api.Events;

import com.univents.univents_api.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("all")
    public Object getAllEvents() {
        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);

    }

    @GetMapping("/{eventId}")
    public Object getOneEvent(@PathVariable int eventId) {
        return new ResponseEntity<>(service.getEventById(eventId), HttpStatus.OK);

    }

    @GetMapping("/name")
    public Object getEventsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getEventsByName(search), HttpStatus.OK);
    }


    @GetMapping("/location/{location}")
    public Object getEventsByLocation(@PathVariable String location) {
        return new ResponseEntity<>(service.getEventsByLocation(location), HttpStatus.OK);
    }

    //fix
    @GetMapping("/creator/{creator}")
    public Object getEventsByUser(@PathVariable User username) {
        return new ResponseEntity<>(service.getEventsByUser(username), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Object createNewEvent(@RequestBody Event event) {
        service.addNewEvent(event);
        return new ResponseEntity<>("New Event Successfuly Created!", HttpStatus.OK);
    }

    @PutMapping("/update/{eventId}")
    public Object updateEvent(@PathVariable int eventId, @RequestBody Event event) {
        service.updateEvent(event);
        return new ResponseEntity<>(service.getEventById(eventId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{eventId}")
    public Object deleteEventById(@PathVariable int eventId) {
        service.deleteEventById(eventId);
        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);
    }
}
