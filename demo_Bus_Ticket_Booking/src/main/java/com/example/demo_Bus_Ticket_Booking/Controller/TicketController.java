package com.example.demo_Bus_Ticket_Booking.Controller;

import com.example.demo_Bus_Ticket_Booking.Entity.Ticket;
import com.example.demo_Bus_Ticket_Booking.Model.BusModel;
import com.example.demo_Bus_Ticket_Booking.Model.TicketModel;
import com.example.demo_Bus_Ticket_Booking.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class TicketController {
    @Autowired
    private TicketService ticketService;
    int busNumber=0;
    @GetMapping("/addTicket")
    public String addTicket(@RequestParam("busNumber") int busNumber, Model model){
        this.busNumber=busNumber;
        TicketModel ticketModel=new TicketModel();
        model.addAttribute("ticketModel",ticketModel);
        return "ticketForm";
    }
    @PostMapping("/saveTicket")
    public String saveTickets(@ModelAttribute("ticketModel") TicketModel ticketModel, Model model){
        model.addAttribute("message",ticketService.saveTickets(ticketModel,this.busNumber));
        return "redirect:/viewTickets?busNumber=" +this.busNumber;
    }
    @GetMapping("/viewTickets")
    public String viewTickets(@RequestParam("busNumber") int busNumber,Model model){
        List<Ticket> ticketList = ticketService.details(busNumber);
        model.addAttribute("ticketList",ticketList);
        model.addAttribute("busNumber",busNumber);
        return "viewAllTickets";
    }

}
