package com.example.UniVentsAdmin.Stats;

import com.example.UniVentsAdmin.Review.Review;
import com.example.UniVentsAdmin.Review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    private final StatsRepository statsRepository;

    @Autowired
    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    // get all reviews
    public List<Stats> getAllStats() {
        return statsRepository.findAll();
    }

}
