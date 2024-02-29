package com.example.demo_Bus_Ticket_Booking.Service;

import com.example.demo_Bus_Ticket_Booking.Entity.Bus;
import com.example.demo_Bus_Ticket_Booking.Entity.Ticket;
import com.example.demo_Bus_Ticket_Booking.Model.TicketModel;
import com.example.demo_Bus_Ticket_Booking.Repository.BusRepo;
import com.example.demo_Bus_Ticket_Booking.Repository.TicketRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private BusRepo busRepo;
    public String saveTickets(TicketModel ticketModel, int Id){
        Ticket ticket=new Ticket();
        BeanUtils.copyProperties(ticketModel,ticket);
        Optional<Bus> bus=busRepo.findAll().stream().filter(i -> i.getBusNumber() == Id).findFirst();
        List<Ticket> ticketList=new ArrayList<>();
        ticketList.addAll(bus.get().getTickets());
        ticketList.add(ticket);
        bus.get().setTicket(ticketList);
        ticket.setBus(bus.get());
        busRepo.save(bus.get());
        return "Course saved Successfully";
    }

    public List<Ticket> details(int busNumber){
        List<Ticket> ticketList=ticketRepo.findAll();
        List<Ticket> tickets=ticketList.stream().filter(i -> i.getBus().getBusNumber()==busNumber).collect(Collectors.toList());
        return tickets;
    }

    public Object bookTicket(int busNumber, int ticket) {
        Bus bus = busRepo.findById(busNumber).orElseThrow(() -> new IllegalArgumentException("Bus not found"));
        bus.setTicket(bus.getTicket() - ticket);
        busRepo.save(bus);
        Ticket ticket1 = new Ticket();
        ticket1.setBus(bus);
        ticket1.setId(ticket);
        ticketRepo.save(ticket1);
        return null;
    }
}
