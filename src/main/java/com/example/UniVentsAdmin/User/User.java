package com.example.UniVentsAdmin.User;

import jakarta.persistence.*;
import java.util.Date;
import java.awt.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String username;
    private String email;
    private String password;
    private String role;
    private String accountStatus;

    @Column(nullable = false)
    Date lastUpdatedAt = new Date();
    Image profilePic = Toolkit.getDefaultToolkit().getImage("");

    // Constructors
    public User(int userId, String username, String email, String password, String role, String accountStatus, Date lastUpdatedAt, Image profilePic) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.accountStatus = accountStatus;
        this.lastUpdatedAt = lastUpdatedAt;
        this.profilePic = profilePic;
    }

    // Always include a no-argument constructor.
    public User() {
    }

    // Getters and Setters
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Image getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Image profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", profilePic=" + profilePic +
                '}';
    }

}

