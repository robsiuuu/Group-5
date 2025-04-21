package uni_vents.com.univents_backend.Events;

import uni_vents.com.univents_backend.Users.User;
import uni_vents.com.univents_backend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }


    public List<Event> getEventsByLocation(String location) {
        return eventRepository.getEventsByLocation(location);
    }

    public List<Event> getEventsByUser(User user) {
        return eventRepository.getEventsByCreator(user.getUserId());
    }

    public List<Event> getEventsByDate(Date eventDate) {
        return eventRepository.getEventsByDate(eventDate);
    }

    public List<Event> getEventsByName(String name) {
        return eventRepository.getEventsByName(name);
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEventById(int eventId) {
        eventRepository.deleteById(eventId);
    }




}
