package com.example.demo_Bus_Ticket_Booking.validation;

import com.example.demo_Bus_Ticket_Booking.Entity.User;
import com.example.demo_Bus_Ticket_Booking.Model.BusModel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import org.springframework.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.HashSet;
import java.util.Set;
@Component
public class NewValidation implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return BusModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BusModel bus = (BusModel) target;

        if (bus.getSource() == null ||bus.getSource()==" " || bus.getSource().isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors,"source", "Source");
        }

        if (bus.getDestination() == null ||bus.getDestination()==" " || bus.getDestination().isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors,"destination", "Destination");
        }

        if (bus.getBusNumber() <= 0) {
            errors.rejectValue("busNumber", "busNumber.No");
        }
        if(Integer.toString(bus.getBusNumber()).length()!=4){
            errors.rejectValue("busNumber","busNumber.empty");
        }
    }

}
