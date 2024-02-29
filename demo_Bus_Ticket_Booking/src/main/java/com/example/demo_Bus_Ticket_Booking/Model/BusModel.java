package com.example.demo_Bus_Ticket_Booking.Model;

import javax.validation.constraints.*;

public class BusModel {
    private int id;
    private int busNumber;
    @NotNull(message = "source must not null")
    private String source;
    private  String destination;
    private int ticket;

    public BusModel() {
    }

    public BusModel(int busNumber, int ticket) {
        this.busNumber = busNumber;
        this.ticket = ticket;
    }

    public BusModel(int busNumber, String source, String destination, int ticket) {
        this.busNumber=busNumber;
        this.source=source;
        this.destination=destination;
        this.ticket=ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "BusModel{" +
                "id=" + id +
                ", busNumber=" + busNumber +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", ticket=" + ticket +
                '}';
    }

}
