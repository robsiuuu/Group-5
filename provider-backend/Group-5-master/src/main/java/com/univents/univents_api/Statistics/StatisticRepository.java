package com.univents.univents_api.Statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer> {

    List<Statistic> findByEventEventId(int eventId);

    List<Statistic> findByUserUserId(int userId);
}
