package com.example.UniVentsAdmin.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserAdminController {

    private final UserService userService;

    @Autowired
    public UserAdminController(UserService userService) {
        this.userService = userService;
    }

    // get all users
    @GetMapping("/admin/users/all")
    public Object getAllUsers(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("title", "All Users");
        return "Users/all_users";
    }

    @GetMapping("/admin/users/search")
    public String searchUsersByUsername(@RequestParam("username") String username, Model model) {
        List<User> users = userService.searchUsersByUsername(username);
        model.addAttribute("usersList", users);
        model.addAttribute("title", "Search Results");
        model.addAttribute("searchTerm", username); // Add this line
        return "Users/all_users";
    }

    @GetMapping("/admin/users/{userId}")
    public Object getUserById(@PathVariable int userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("title", "User #: " + userId);
        return "Users/user_details";
    }

    @GetMapping("/admin/users/update/{userId}")
    public String showUpdateForm(@PathVariable int userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("title", "Update User");
        return "Users/user_update";
    }

    // Update user by id
    @PostMapping("/admin/users/update/{userId}")
    public Object updateStudent(@PathVariable int userId, User user) {
        userService.updateUser(user);
        return "redirect:/admin/users/" + userId;
    }

    // Delete user by ID
    @GetMapping("/admin/users/ban/{userId}")
    public Object deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/users/all";
    }

}
