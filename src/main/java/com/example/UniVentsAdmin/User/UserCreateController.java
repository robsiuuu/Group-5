package com.example.UniVentsAdmin.User;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserCreateController {

    private final UserService userService;

    @Autowired
    public UserCreateController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showCreateForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("title", "Create New User");
        return "Interfaces/signup";
    }

    @PostMapping("/users/new")
    public String createUser(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role,  // Will be "CUSTOMER" or "PROVIDER"
            HttpSession session) {

        // 1. Create the user (pseudo-code)
        User newUser = userService.createUserWithRole(email, password, String.valueOf(User.Role.valueOf(role)));

        // 2. Set session attributes
        session.setAttribute("authenticated", true);
        session.setAttribute("userId", newUser.getUserId());
        session.setAttribute("role", newUser.getRole().name());
        session.setAttribute("email", newUser.getEmail());

        // 3. Redirect based on role
        return "redirect:/choose-role";
    }

    @GetMapping("/userInfo")
    public Object getUserInfo(Model model, @SessionAttribute("user") User currentUser){
        model.addAttribute("user", currentUser);
        return "Users/user-details";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user, HttpSession session) {
        userService.updateUser(user);
        User updatedUser = userService.getUserById(user.getUserId());
        session.setAttribute("user", updatedUser);

        return "redirect:/userInfo";
    }

    @GetMapping("/users/delete/{userId}")
    public Object deleteUser(@PathVariable("userId") int userId, HttpSession session) {
        userService.deleteUser(userId);
        session.invalidate();
        return "redirect:/index";
    }

}
