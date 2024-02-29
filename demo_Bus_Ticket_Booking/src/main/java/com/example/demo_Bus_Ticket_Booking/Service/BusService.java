package com.example.demo_Bus_Ticket_Booking.Service;

import com.example.demo_Bus_Ticket_Booking.Entity.Bus;
import com.example.demo_Bus_Ticket_Booking.Entity.User;
import com.example.demo_Bus_Ticket_Booking.Model.BusModel;
import com.example.demo_Bus_Ticket_Booking.Repository.BusRepo;
import com.example.demo_Bus_Ticket_Booking.Repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusService {
    @Autowired
    private BusRepo busRepo;
    @Autowired
   private UserRepo userRepo;
    private int userid;
    private String username;
    public String saveBus(BusModel busModel){
        if(busModel==null){
            return "Bus not found";
        }
        else {
            Bus bus=new Bus();
            BeanUtils.copyProperties(busModel,bus);
            busRepo.save(bus);
            return "Bus saved successfully";
        }
    }
    public String saveBus1(int busNumber,int ticket,int noOftickets){
            Bus bus=busRepo.findAll().stream().filter(i->i.getBusNumber()==busNumber).findFirst().orElse(null);
           if(bus!=null){
               Set<Bus> busses=new HashSet<>();
               busses.add(bus);

               User user=userRepo.getReferenceById(userid);
               Set<Bus> busSet= user.getBuses();
               busSet.add(bus);

               Set<User> userSet=bus.getUsers();
               userSet.add(user);
               bus.setTicket((ticket-noOftickets));
               busRepo.save(bus);
               userRepo.save(user);
               return "Bus saved successfully";
           }
           return "Bus not found";
    }
    public List<BusModel> getAll(){
        List<Bus> busList=busRepo.findAll();
        List<BusModel> busModelList=new ArrayList<>();

        busList.forEach(bus -> {
            BusModel busModel=new BusModel();
            BeanUtils.copyProperties(bus,busModel);
            busModelList.add(busModel);
        });
        return busModelList;
    }
    public ArrayList<BusModel> getBusList() {
        List<Bus> busList=busRepo.findAll();
        List<BusModel> busModelList=new ArrayList<>();
        busList.forEach(bus -> {
            BusModel busModel=new BusModel();
            BeanUtils.copyProperties(bus,busModel);
            busModelList.add(busModel);
        });
        return (ArrayList<BusModel>) busModelList;
    }
    public BusModel getBusById(int id) {
        Optional<Bus> bus = busRepo.findById(id);
        if (bus.isPresent()) {
            BusModel busModel = new BusModel();
            BeanUtils.copyProperties(bus,busModel);
            return busModel;
        }
        return null;
    }
    public List<BusModel> findBySourceAndDestination(BusModel busModel, String source, String destination,String username) {
        this.userid=userRepo.findAll().stream().filter(i->i.getUsername().equalsIgnoreCase(username)).findFirst().get().getId();
        List<Bus> busList = busRepo.findAll();
        List<BusModel> busModelList = new ArrayList<>();
        busList.stream()
                .filter(bus -> bus.getSource().equals(source) && bus.getDestination().equals(destination))
                .forEach(bus -> {
                    BusModel busModel1 = new BusModel();
                    BeanUtils.copyProperties(bus, busModel1);
                    busModelList.add(busModel1);
                });
        return busModelList;
    }
    public void removeBus(int busNumber) {
        System.out.println("before");
        int id = busRepo.findAll().stream().filter(i-> i.getBusNumber()== busNumber).findFirst().get().getId();

        System.out.println("after");
        if(id >0){
            busRepo.deleteById(id);
        }
    }

}
