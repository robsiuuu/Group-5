package com.example.UniVentsAdmin.Statistics;

import com.example.UniVentsAdmin.Event.Event;
import com.example.UniVentsAdmin.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer> {

    List<Statistic> findByEventEventId(int eventId);

    List<Statistic> findByUserUserId(int userId);

    Optional<Statistic> findByEventAndUser(Event event, User user);

}
