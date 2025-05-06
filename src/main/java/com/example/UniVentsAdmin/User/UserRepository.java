package com.example.UniVentsAdmin.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUsernameContainingIgnoreCase(String username);

    User findByUsername(String username);

    User findByEmail(String email);

}