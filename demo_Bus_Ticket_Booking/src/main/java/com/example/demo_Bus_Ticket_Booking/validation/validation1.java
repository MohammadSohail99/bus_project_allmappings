package com.example.demo_Bus_Ticket_Booking.validation;

import com.example.demo_Bus_Ticket_Booking.Entity.Admin;
import com.example.demo_Bus_Ticket_Booking.Entity.User;
import com.example.demo_Bus_Ticket_Booking.Model.BusModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class validation1 implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Admin.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admin user = (Admin) target;

        if (user.getUsername() == null || user.getUsername().isBlank()){
            ValidationUtils.rejectIfEmpty(errors,"username", "Username");
        }
        if (user.getPassword() == null || user.getUsername().isEmpty() || user.getPassword().length()<3) {
            ValidationUtils.rejectIfEmpty(errors,"password", "Password");
        }
        if (user.getEmail()!=null && !user.getEmail().endsWith("@gmail.com")) {
            errors.rejectValue("email", "Email");
        }
        if (user.getEmail().isBlank()) {
            errors.rejectValue("email", "Gmail");
        }
    }
}
