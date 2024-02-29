package com.example.demo_Bus_Ticket_Booking.Repository;

import com.example.demo_Bus_Ticket_Booking.Entity.Admin;
import com.example.demo_Bus_Ticket_Booking.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
