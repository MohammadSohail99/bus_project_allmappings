package com.example.demo_Bus_Ticket_Booking.Model;

import com.example.demo_Bus_Ticket_Booking.Entity.Bus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TicketModel {
    private int id;
    private BusModel busModel;

    public TicketModel() {
    }

    public TicketModel(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusModel getBusModel() {
        return busModel;
    }

    public void setBusModel(BusModel busModel) {
        this.busModel = busModel;
    }
}
