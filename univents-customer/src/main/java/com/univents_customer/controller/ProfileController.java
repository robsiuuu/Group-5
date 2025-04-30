package com.univents_customer.controller;

import com.univents_customer.model.User;
import com.univents_customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getProfile(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable Long id, @RequestBody User updatedUser,
                                                @RequestParam(required = false) String currentPassword) {
        Optional<User> existingUserOptional = userService.findById(id);
        if (existingUserOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingUser = existingUserOptional.get();

        // Print stored password and entered current password
        System.out.println("Stored Password: " + existingUser.getPassword());
        System.out.println("Entered Current Password: " + currentPassword);

        // Require correct current password before allowing a password update
        if (currentPassword != null && !currentPassword.isEmpty()) {
            if (!existingUser.getPassword().equals(currentPassword)) {
                System.out.println("Password check failed!");
                return ResponseEntity.badRequest().body("Error: Incorrect current password!");
            }
            System.out.println("Password check passed!");

            // Only update password if a new one is provided
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                existingUser.setPassword(updatedUser.getPassword());
            }
        }

        // Prevent duplicate email
        if (!existingUser.getEmail().equals(updatedUser.getEmail()) &&
                userService.findByEmail(updatedUser.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Email already in use!");
        }

        // Prevent duplicate username
        if (!existingUser.getUsername().equals(updatedUser.getUsername()) &&
                userService.findByUsername(updatedUser.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Username already in use!");
        }

        // Update only changed fields
        if (updatedUser.getUsername() != null && !updatedUser.getUsername().isEmpty()) {
            existingUser.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getEmail() != null && !updatedUser.getEmail().isEmpty()) {
            existingUser.setEmail(updatedUser.getEmail());
        }

        // Save the updated user
        userService.registerUser(existingUser);
        return ResponseEntity.ok("Profile updated successfully!");

    }
}