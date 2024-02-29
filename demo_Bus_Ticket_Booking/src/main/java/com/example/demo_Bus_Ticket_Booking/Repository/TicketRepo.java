package com.example.demo_Bus_Ticket_Booking.Repository;

import com.example.demo_Bus_Ticket_Booking.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Integer> {
}
