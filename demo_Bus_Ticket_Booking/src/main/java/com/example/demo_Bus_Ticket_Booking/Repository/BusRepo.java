package com.example.demo_Bus_Ticket_Booking.Repository;

import com.example.demo_Bus_Ticket_Booking.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepo extends JpaRepository<Bus,Integer> {
    List<Bus> findBySourceAndDestination(String source, String destination);

}
