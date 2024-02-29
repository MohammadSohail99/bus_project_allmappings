package com.example.demo_Bus_Ticket_Booking.Entity;

import com.example.demo_Bus_Ticket_Booking.Model.BusModel;
import jakarta.persistence.*;

@Entity
public class Ticket {

    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int tid;
    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    public Ticket() {
    }

    public Ticket(int id,Bus bus) {
        this.id = id;
        this.bus = bus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
