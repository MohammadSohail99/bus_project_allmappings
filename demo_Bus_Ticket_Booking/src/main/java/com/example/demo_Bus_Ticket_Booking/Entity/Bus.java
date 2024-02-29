package com.example.demo_Bus_Ticket_Booking.Entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int busNumber;
    @NotNull(message = "This should be not null")
    private String source;
    private  String destination;
    private int ticket;
    /*@ManyToOne
    @JoinColumn(name = "username")
    private Admin admin;*/

    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    @ManyToMany
    @JoinTable(
            name = "user_bus",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    public Bus(int id, int busNumber, String source, String destination, int ticket) {
        this.id = id;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.ticket = ticket;
    }

    public Bus() {

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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTicket(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", busNumber='" + busNumber + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", ticket=" + ticket +
                '}';
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
