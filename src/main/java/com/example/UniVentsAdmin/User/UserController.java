package com.example.UniVentsAdmin.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get all users
    @GetMapping("/all")
    public Object getAllStudents() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    // Update user by id
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int userId, @RequestBody User user) {
        user.setUserId(userId);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user by ID
    @DeleteMapping("/ban/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
