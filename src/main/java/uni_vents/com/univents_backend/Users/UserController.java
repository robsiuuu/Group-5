package uni_vents.com.univents_backend.Users;

import jakarta.servlet.http.HttpSession;
import uni_vents.com.univents_backend.Events.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    EventService eventService;

    @GetMapping("/all")
    public Object getAllStudents() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public Object getUserById(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/loginForm")
    public Object login() {
        return "user-login";
    }

    @GetMapping("/registerForm")
    public Object register(){
        return "user-register";
    }

    @GetMapping("/home")
    public Object homePage(){
        return "user-home";
    }

    /**
     *
     * @param username is the username of the person being logged in
     * @param password is the password of the person being logged in
     * @param model is used to add an error alert
     * @param session is used to store the user info request across the entire browsing process
     * @return will return either home page or the login page for invalid password/username
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            //if user exists and psaswords matches then save user in session as user to be called anytime
            session.setAttribute("user", user);

            //redirect
            return "/user-home"; //or to home page/dashboard (not set up yet)
        } else {
            //this is an error mark to indicate invalid error or password which will be popped up in the front end
            model.addAttribute("error", "Invalid username or password");
            return "user-login";
        }
    }
    @PostMapping("/register")
    public String addNewUser(@ModelAttribute User user, Model model) {
        try {
            // Optionally set defaults
            if (user.getAccountStatus() == null || user.getAccountStatus().isEmpty()) {
                user.setAccountStatus("active");
            }

            userService.addNewUser(user);
            model.addAttribute("message", "User registered successfully!");
            return "redirect:/users/loginForm"; // Redirect to login page or dashboard
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "user-register"; // Return to form on error
        }
    }

    @GetMapping("/userInfo")
    public Object getUserInfo(Model model, @SessionAttribute("user") User currentUser){
        model.addAttribute("user", currentUser);
        return "user-details";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user, HttpSession session) {
        userService.updateUser(user);
        User updatedUser = userService.getUserById(user.getUserId());
        session.setAttribute("user", updatedUser);

        return "redirect:/users/userInfo";
    }

    @GetMapping("/delete/{userId}")
    public Object deleteUser(@PathVariable("userId") int userId, HttpSession session) {
        userService.deleteUser(userId);
        session.invalidate();
        return "redirect:/users/loginForm";
    }

    @GetMapping("/logout")
    public Object logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/users/loginForm";
    }

}
