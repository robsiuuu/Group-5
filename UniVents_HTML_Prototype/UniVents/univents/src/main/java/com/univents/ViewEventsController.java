package com.univents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewEventsController {

    @GetMapping("/view-events")
    public String showEventsPage() {
        return "view-events"; // Serves view-events.html
    }
}
