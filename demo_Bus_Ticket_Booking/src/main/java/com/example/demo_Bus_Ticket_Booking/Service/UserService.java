package com.example.demo_Bus_Ticket_Booking.Service;

import com.example.demo_Bus_Ticket_Booking.Entity.User;
import com.example.demo_Bus_Ticket_Booking.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    int userid;
    public User registerUser(User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(hashPassword(user.getPassword()));
        return userRepo.save(user);
    }

    private String hashPassword(String password) {
        return password;
    }

    public User loginUser(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            userid=user.getId();
            return user;
        }
        return null;
    }
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
