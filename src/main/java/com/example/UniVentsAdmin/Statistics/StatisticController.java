package com.example.UniVentsAdmin.Statistics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @PostMapping("/create")
    public Object createStatistic(@RequestBody Statistic statistic, @RequestParam int eventId, @RequestParam int userId) {
        return new ResponseEntity<>(statisticService.createStatistic(statistic, eventId, userId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public Object getAllStatistics() {
        return new ResponseEntity<>(statisticService.getAllStatistics(), HttpStatus.OK);
    }

    @GetMapping("/event/{eventId}")
    public Object getStatisticsByEvent(@PathVariable int eventId) {
        return new ResponseEntity<>(statisticService.getStatisticsByEvent(eventId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public Object getStatisticByUser(@PathVariable int userId) {
        return new ResponseEntity<>(statisticService.getStatisticsByUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{statisticId}")
    public Object deleteStatistic(@PathVariable int statisticId) {
        statisticService.deleteStatistic(statisticId);
        return new ResponseEntity<>("Statistic deleted successfully", HttpStatus.OK);
    }


}
