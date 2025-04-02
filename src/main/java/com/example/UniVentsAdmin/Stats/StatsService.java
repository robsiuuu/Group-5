package com.example.UniVentsAdmin.Stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StatsService {

    private final StatsRepository statsRepository;

    @Autowired
    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    // get all stats
    public List<Stats> getAllStats() {
        return statsRepository.findAll();
    }

}
