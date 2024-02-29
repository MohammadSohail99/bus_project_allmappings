package com.example.demo_Bus_Ticket_Booking.Controller;

import com.example.demo_Bus_Ticket_Booking.Entity.Admin;
import com.example.demo_Bus_Ticket_Booking.Service.AdminService;
import com.example.demo_Bus_Ticket_Booking.validation.NewValidation;
import com.example.demo_Bus_Ticket_Booking.validation.validation1;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/adminregister")
    public Admin adminregister(@RequestBody Admin admin){
        return adminService.add(admin);
    }
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        Admin user=new Admin();
        model.addAttribute("user",user);
        return "registerForm";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Admin user, BindingResult bindingResult) {
        adminService.registerUser(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        Admin user = adminService.loginUser(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/first";
        } else {
            model.addAttribute("loginFailed", true);
            return "notaccept";
        }
    }

}
