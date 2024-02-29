package com.example.demo_Bus_Ticket_Booking.Controller;

import com.example.demo_Bus_Ticket_Booking.Entity.Bus;
import com.example.demo_Bus_Ticket_Booking.Entity.Ticket;
import com.example.demo_Bus_Ticket_Booking.Model.BusModel;
import com.example.demo_Bus_Ticket_Booking.Model.TicketModel;
import com.example.demo_Bus_Ticket_Booking.Service.BusService;
import com.example.demo_Bus_Ticket_Booking.Service.TicketService;
import com.example.demo_Bus_Ticket_Booking.validation.NewValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class BusController {
    @Autowired
    private BusService busService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    NewValidation valid;
    private int busNumber=0;

    @RequestMapping("/first")
    public String first(){
        return "first";
    }
    @GetMapping("/addBus")
    public String addStudent(ModelMap model){
        BusModel busModel=new BusModel();
        model.addAttribute("busModel",busModel);
        return "addBusForm";
    }
    @PostMapping("/saveBus")
    public String saveStudent(@Valid @ModelAttribute("busModel") BusModel busModel,BindingResult bindingResult, Model model){
        valid.validate(busModel,bindingResult);
        if(bindingResult.hasErrors()) return "addBusForm";
        model.addAttribute("message",busService.saveBus(busModel));
        List<BusModel> busList=busService.getAll();
        model.addAttribute("busList",busList);
        return "viewAllBusses";
    }
    @GetMapping("/viewBusses")
    public String viewStudent(Model model){
        model.addAttribute("busList",busService.getAll());
        return "viewAllBusses";
    }
    @GetMapping("/viewbusses")
    public String viewStudent1(Model model){
        model.addAttribute("busList",busService.getAll());
        return "viewbusses";
    }
    @PostMapping("/searchBus")
    public String searchBus(@ModelAttribute("busModel") BusModel busModel,@RequestParam("username")String username, @RequestParam String source, @RequestParam String destination, Model model) {
        List<BusModel> busList = busService.findBySourceAndDestination(busModel, source, destination,username);
        System.out.println(username);
        model.addAttribute("busList", busList);
        model.addAttribute("busModel",busModel);
        return "search";
    }
    @GetMapping("/bookTicket")
    public String bookTicket(@RequestParam("busNumber") int busNumber,@RequestParam("ticket") int ticket, Model model){
        model.addAttribute("busNumber",busNumber);
        model.addAttribute("ticket",ticket);
        return "bookTicket";
    }
    @RequestMapping("bookticket")
    public String bookticket(@RequestParam("busNumber")int busNUmber,@RequestParam("ticket")int ticket,@RequestParam("numberOfTickets") int numberOfTickets, Model model){
        model.addAttribute("message",busService.saveBus1(busNUmber,ticket,numberOfTickets));
        if(numberOfTickets<=ticket){
            return "youcanbook";
        }
        return "notavailable";
    }
    @RequestMapping("/deleteBus")
    public String deletBus(@RequestParam("busNumber")int busNumber,Model model){
        busService.removeBus(busNumber);
        return "redirect:/viewbusses";
    }

}
