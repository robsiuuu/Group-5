package com.univents_customer.service;

import com.univents_customer.model.Event;
import com.univents_customer.model.Subscription;
import com.univents_customer.model.User;
import com.univents_customer.model.repository.EventRepository;
import com.univents_customer.model.repository.SubscriptionRepository;
import com.univents_customer.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public String subscribeUserToEvent(Long userId, Long eventId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return "User not found";
        }

        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isEmpty()) {
            return "Event not found";
        }

        boolean alreadySubscribed = subscriptionRepository.existsByUserAndEvent(user.get(), event.get());
        if (alreadySubscribed) {
            return "Already subscribed";
        }

        Subscription subscription = new Subscription(user.get(), event.get());
        subscriptionRepository.save(subscription);
        return "Success";
    }

    public String unsubscribeUserFromEvent(Long userId, Long eventId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return "User not found";
        }

        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isEmpty()) {
            return "Event not found";
        }

        Optional<Subscription> subscription = subscriptionRepository.findByUserAndEvent(user.get(), event.get());
        if (subscription.isEmpty()) {
            return "Subscription not found";
        }

        subscriptionRepository.delete(subscription.get());
        return "Unsubscribed";
    }
}
