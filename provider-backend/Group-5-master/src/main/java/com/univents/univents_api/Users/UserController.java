package com.univents.univents_api.Users;

import com.univents.univents_api.Events.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/register")
    public Object addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return new ResponseEntity<>("New User Successfully Created!", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public Object updateUser(@PathVariable("id") int userId, @RequestBody User user) {
        user.setUserId(userId);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Profile successfully deleted!", HttpStatus.OK);
    }

}
