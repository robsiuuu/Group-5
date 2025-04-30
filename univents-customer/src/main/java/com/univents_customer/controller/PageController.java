package com.univents_customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/index")
    public String showIndexPage() {
        return "index";  // Public landing page (not logged in)

    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @GetMapping("/profile")
    public String showProfilePage() {
        return "profile";
    }

    @GetMapping("/write-review")
    public String showWriteReviewPage() {
        return "write-review";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // Dashboard (after login)

    }

    @GetMapping("/view-events")
    public String showViewEventsPage() {
        return "view-events";

    }

    @GetMapping("/subscriptions")
    public String showSubscriptionsPage() {
        return "subscriptions";
    }
}
