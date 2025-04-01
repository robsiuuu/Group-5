package com.univents_customer.model.repository;

import com.univents_customer.model.Subscription;
import com.univents_customer.model.User;
import com.univents_customer.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByUserAndEvent(User user, Event event);
    Optional<Subscription> findByUserAndEvent(User user, Event event);
}
