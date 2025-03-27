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

    // Update user
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

}
