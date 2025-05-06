package com.example.UniVentsAdmin;

import com.example.UniVentsAdmin.Event.Event;
import com.example.UniVentsAdmin.Event.EventService;
import com.example.UniVentsAdmin.User.User;
import com.example.UniVentsAdmin.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
public class PageController {

    private final UserService userService;
    private final EventService eventService;

    public PageController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("/choose-role")
    public String roleSelectionPage() {
        return "Interfaces/WhoAreYou";
    }

    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam String role,
            Model model
    ) {
        model.addAttribute("role", role.toLowerCase());
        return "Interfaces/login";
    }

    @PostMapping("/authenticate")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role,
            HttpSession session,
            Model model
    ) {
        username = username.trim();
        password = password.trim();

        try {
            User.Role inputRole = User.Role.valueOf(role.toUpperCase());
            User user = userService.findByUsername(username);

            if (user == null) {
                model.addAttribute("error", "Invalid username or password");
                model.addAttribute("role", role.toLowerCase());
                return "redirect:/choose-role";
            }

            if (user.getRole() == inputRole && user.getPassword().equals(password)) {
                // Store all user attributes including full User object
                session.setAttribute("authenticated", true);
                session.setAttribute("userId", user.getUserId());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole().name().toLowerCase());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("user", user); // Critical addition

                session.setMaxInactiveInterval(30 * 60);
                return "redirect:/" + user.getRole().name().toLowerCase() + "/dashboard";
            } else {
                model.addAttribute("error", "Invalid credentials for " + role + " role");
                model.addAttribute("role", role.toLowerCase());
                return "redirect:/choose-role";
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Invalid role specified");
            model.addAttribute("role", role.toLowerCase());
            return "redirect:/choose-role";
        }
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session, Model model) {
        if (!isAuthenticated(session, "admin")) {
            return "redirect:/login?role=admin";
        }
        model.addAttribute("user", session.getAttribute("username"));
        return "Interfaces/admin_dashboard";
    }

    @GetMapping("/customer/dashboard")
    public String customerDashboard(HttpSession session, Model model) {
        if (!isAuthenticated(session, "customer")) {
            return "redirect:/login?role=customer";
        }
        model.addAttribute("user", session.getAttribute("username"));
        return "Interfaces/customer_dashboard";
    }

    @GetMapping("/provider/dashboard")
    public String providerDashboard(HttpSession session, Model model) {
        if (!isAuthenticated(session, "provider")) {
            return "redirect:/login?role=provider";
        }
        model.addAttribute("user", session.getAttribute("username"));
        return "Interfaces/provider_dashboard";
    }

    @GetMapping("/provider/manage-events")
    public String manageEvents(Model model, HttpSession session) {
        // First check authentication
        if (!isAuthenticated(session, "provider")) {
            return "redirect:/login?role=provider";
        }

        // Get user from session (either approach works now)
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // Fallback to get by ID if needed
            Integer userId = (Integer) session.getAttribute("userId");
            user = userService.getUserById(userId);
        }

        List<Event> events = eventService.getEventsByUser(user);
        model.addAttribute("eventList", events != null ? events : Collections.emptyList());

        return "Events/event-list";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "Interfaces/index";
    }

    @GetMapping("/view-events")
    public Object showViewEventsPage() {
        return "Interfaces/view-events";
    }

    private boolean isAuthenticated(HttpSession session, String requiredRole) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        String userRole = (String) session.getAttribute("role");
        return authenticated != null && authenticated &&
                requiredRole.equalsIgnoreCase(userRole);
    }

}