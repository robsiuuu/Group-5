package com.example.UniVentsAdmin.User;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    public enum Role {
        CUSTOMER, PROVIDER, ADMIN;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String username;
    private String email;
    private String password;
    private String accountStatus;

    @Column(nullable = false)
    Date lastUpdatedAt = new Date();

    // Constructors
    public User(Role role, int userId, String username, String email, String password, String accountStatus, Date lastUpdatedAt) {
        this.role = role;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    // Always include a no-argument constructor.
    public User() {
    }

    // Getters and Setters
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", lastUpdatedAt=" + lastUpdatedAt +
                '}';
    }

}

