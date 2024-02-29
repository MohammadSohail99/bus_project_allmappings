package com.example.demo_Bus_Ticket_Booking.Service;

import com.example.demo_Bus_Ticket_Booking.Entity.Admin;
import com.example.demo_Bus_Ticket_Booking.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public Admin add(Admin admin){

        return admin;
    }
    public Admin registerUser(Admin user) {
        if (adminRepo.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(hashPassword(user.getPassword()));
        return adminRepo.save(user);
    }
    private String hashPassword(String password) {
        return password;
    }

    public Admin loginUser(String username, String password) {
        Admin user = adminRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {

            return user;
        }
        return null;
    }
    public Admin findByUsername(String username) {
        return adminRepo.findByUsername(username);
    }

}
