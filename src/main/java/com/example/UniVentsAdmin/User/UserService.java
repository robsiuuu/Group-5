package com.example.UniVentsAdmin.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Search users by username
    public List<User> searchUsersByUsername(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public User createUserWithRole(String email, String password, String role) {
        User.Role userRole;
        try {
            userRole = User.Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role specified");
        }

        if (userRepository.findByEmail(email) != null) {
            throw new IllegalStateException("Email already taken");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // Remember to hash in production!
        user.setRole(userRole);
        user.setAccountStatus("ACTIVE");

        // Set username if needed (or modify as per your requirements)
        user.setUsername(email.split("@")[0]); // Using part before @ as username

        return userRepository.save(user);
    }

    // Update user
    public void updateUser(User user) {
        //Technically the 4 lines above are not necessary because the save method merges by default.
        userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

}
