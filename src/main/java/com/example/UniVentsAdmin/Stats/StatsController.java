package com.example.UniVentsAdmin.Stats;

import com.example.UniVentsAdmin.Stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    // get all reviews
    @GetMapping("/all")
    public Object getAllStats() {
        return new ResponseEntity<>(statsService.getAllStats(), HttpStatus.OK);
    }

}
