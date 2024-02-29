package com.example.demo_Bus_Ticket_Booking.Controller;

import com.example.demo_Bus_Ticket_Booking.Entity.Admin;
import com.example.demo_Bus_Ticket_Booking.Entity.User;
import com.example.demo_Bus_Ticket_Booking.Service.AdminService;
import com.example.demo_Bus_Ticket_Booking.Service.UserService;
import com.example.demo_Bus_Ticket_Booking.validation.NewValidation;
import com.example.demo_Bus_Ticket_Booking.validation.validation2;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    validation2 valid;
    @GetMapping("/registeruser")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registerUserForm";
    }
    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult bindingResult) {
        valid.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "registerUserForm";
        }
        userService.registerUser(user);
        return "redirect:/loginuser";
    }
    @GetMapping("/loginuser")
    public String showLoginForm() {
        return "loginUserForm";
    }

    @PostMapping("/loginuser")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("username",username);
            return "homepage";
        } else {
            model.addAttribute("loginFailed", true);
            return "notaccept";
        }
    }
}
