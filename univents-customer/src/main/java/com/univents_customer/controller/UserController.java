package com.univents_customer.controller;

import com.univents_customer.model.User;
import com.univents_customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String email = request.get("email");
        String password = request.get("password");
        String confirmPassword = request.get("confirmPassword");

        // Debug: Check if confirmPassword is missing
        if (confirmPassword == null || confirmPassword.isEmpty()) {
            System.out.println("ERROR: confirmPassword is missing from the request!");
            return ResponseEntity.badRequest().body(Map.of("message", "Error: Confirm Password is missing!"));
        }

        // Normalize and trim passwords to remove extra spaces or hidden characters
        password = Normalizer.normalize(password.trim(), Normalizer.Form.NFC);
        confirmPassword = Normalizer.normalize(confirmPassword.trim(), Normalizer.Form.NFC);

        // Debugging: Print passwords and their lengths
        System.out.println("Received Password: " + password + " (Length: " + password.length() + ")");
        System.out.println("Received Confirm Password: " + confirmPassword + " (Length: " + confirmPassword.length() + ")");

        boolean emailExists = userService.findByEmail(email).isPresent();
        boolean usernameExists = userService.findByUsername(username).isPresent();

        // 1. Prioritize checking for existing users first
        if (emailExists && usernameExists) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error: Email and username already taken!"));
        }
        if (emailExists) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error: Email already exists!"));
        }
        if (usernameExists) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error: Username already exists!"));
        }

        // 2. If username and email are unique, check passwords
        if (!password.equals(confirmPassword)) {
            System.out.println("ERROR: Passwords do not match!");
            return ResponseEntity.badRequest().body(Map.of("message", "Error: Passwords do not match!"));
        }

        // 3. If everything is fine, create the new user
        User user = new User(username, password, email);
        userService.registerUser(user);

        // Confirm user was saved
        Optional<User> savedUser = userService.findByEmail(email);
        if (savedUser.isPresent()) {
            System.out.println("SUCCESS: User registered with ID: " + savedUser.get().getId());

            // Use HashMap to allow different data types
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User registered successfully!");
            response.put("userId", savedUser.get().getId());
            return ResponseEntity.ok(response);
        } else {
            System.out.println("ERROR: User registration failed!");
            return ResponseEntity.badRequest().body(Map.of("message", "Error: User registration failed!"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {
        Optional<User> foundUser = userService.findByEmail(user.getEmail());

        if (foundUser.isPresent() && foundUser.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(Map.of(
                    "id", foundUser.get().getId(),
                    "username", foundUser.get().getUsername(),
                    "message", "Login successful!"
            ));
        } else {
            return ResponseEntity.badRequest().body(Map.of("message", "Invalid email or password."));
        }
    }
}
