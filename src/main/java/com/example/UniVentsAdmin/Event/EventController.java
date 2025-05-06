package com.example.UniVentsAdmin.Event;

import com.example.UniVentsAdmin.Reviews.ReviewService;
import com.example.UniVentsAdmin.Statistics.StatisticService;
import com.example.UniVentsAdmin.User.User;
import com.example.UniVentsAdmin.User.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @Autowired
    private UserService userService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public Object getAllEvents(Model model) {
//        return new ResponseEntity<>(service.getAllEvents(), HttpStatus.OK);
        model.addAttribute("eventList", service.getAllEvents());
        model.addAttribute("title", "All Events");
        return "events-all";

    }

    @GetMapping("/myEvents")
    public Object getMyEvents(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/choose-role";
        }

        List<Event> myEvents = service.getEventsByUser(user);

        model.addAttribute("eventList", myEvents);
        model.addAttribute("title", "My Events");
        return "Events/event-list";

    }


    @GetMapping("/{eventId}")
    public Object getOneEvent(@PathVariable int eventId, Model model) {
        model.addAttribute("event", service.getEventById(eventId));
        model.addAttribute("statistic", statisticService.getStatisticsByEvent(eventId));
        model.addAttribute("title", "Event");
        model.addAttribute("reviewList", reviewService.getReviewByEventId(eventId));
        return "Events/event-details";

    }

    @GetMapping("/{eventId}/click")
    public Object getClicks(@PathVariable int eventId, HttpSession session){
        User user = (User) session.getAttribute("user");
        Event event = service.getEventById(eventId);
        statisticService.trackClick(event, user);
        return "redirect:/events/{eventId}";
    }


    @GetMapping("/name")
    public Object getEventsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getEventsByName(search), HttpStatus.OK);
    }


    @GetMapping("/location/{location}")
    public Object getEventsByLocation(@PathVariable String location) {
        return new ResponseEntity<>(service.getEventsByLocation(location), HttpStatus.OK);
    }




//    @PostMapping("/create")
//    public Object createNewEvent(@RequestBody Event event) {
//        service.addNewEvent(event);
//        return new ResponseEntity<>("New Event Successfuly Created!", HttpStatus.OK);
//    }

    /**
     * Show the view for a new Event Form.
     *
     * @parammodel
     * @return the form view
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Event event = new Event();
        if (event.getEventDate() == null) {
            event.setEventDate(new Date());
        }
        if (event.getEventTime() == null) {
            event.setEventTime(new Date());
        }
        model.addAttribute("event", event);
        model.addAttribute("title", "Create New Event");
        return "Events/event-create";
    }


    /**
     * Create a new Event entry
     * @paramevent the new event object
     * @return the updated list of events
     */
    @PostMapping("/new")
    public Object addNewEvent(Event event, HttpSession session, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude){
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return "redirect:/choose-role";
        }
        event.setLatitude(latitude);
        event.setLongitude(longitude);

        event.setCreator(currentUser);
        service.addNewEvent(event);
        return "redirect:/events/myEvents";
    }

    @GetMapping("/editForm")
    public Object showEditForm(@RequestParam("id") int eventId, Model model){
        Event event = service.getEventById(eventId);
        model.addAttribute("event", event);
        model.addAttribute("title", "Edit Event");
        return "Events/event-edit";
    }

    @PostMapping("/update")
    public Object updateEvent(@ModelAttribute Event event, HttpSession session, Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Please input all fields");
            model.addAttribute("event", event);
            return "events/editForm";
        }
        User currentCreator = (User) session.getAttribute("user");
        event.setCreator(currentCreator);
        service.updateEvent(event);
        return "redirect:/events/myEvents";
    }

    @GetMapping("/delete/{eventId}")
    public Object deleteEventById(@PathVariable int eventId) {
        service.deleteEventById(eventId);
        return "redirect:/events/myEvents";
    }
}
