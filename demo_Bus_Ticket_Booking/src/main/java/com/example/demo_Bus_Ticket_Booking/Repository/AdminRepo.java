package com.example.demo_Bus_Ticket_Booking.Repository;

import com.example.demo_Bus_Ticket_Booking.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

    Admin findByUsername(String username);
}
