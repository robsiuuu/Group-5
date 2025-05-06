package com.example.UniVentsAdmin.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventAdminController {

    private final EventService eventService;

    @Autowired
    public EventAdminController(EventService eventService) {
        this.eventService = eventService;
    }

    // get all events
    @GetMapping("/admin/events/all")
    public Object getAllEvents(Model model) {
        model.addAttribute("eventsList", eventService.getAllEvents());
        model.addAttribute("title", "All Events");
        return "Events/all_events";
    }

    @GetMapping("/admin/events/{eventId}")
    public Object getUserById(@PathVariable int eventId, Model model) {
        model.addAttribute("event", eventService.getEventById(eventId));
        model.addAttribute("title", "Event #: " + eventId);
        return "Events/admin_event_details";
    }

    // Delete events by ID
    @GetMapping("/admin/events/ban/{eventId}")
    public Object deleteUser(@PathVariable int eventId) {
        eventService.deleteEventById(eventId);
        return "redirect:/admin/events/all";
    }



}
