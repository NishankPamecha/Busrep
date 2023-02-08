package com.example.demo.Services;

import com.example.demo.Models.Bus;
import com.example.demo.Models.Ticket;
import com.example.demo.Repository.BusRepo;
import com.example.demo.Repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private BusRepo busRepo;


    public List<Ticket> getAllTickets(){
        return ticketRepo.findAll();
    }

    public String bookTicket(Ticket ticket){
        ticketRepo.save(ticket);
        return "Ticket booked successfully";
    }

    public Optional<Ticket> findTicketById(String id) {
        return ticketRepo.findById(id);
    }

    public String deleteTicket(String id) {
        ticketRepo.deleteById(id);
        return "Ticket of id "+ id + " deleted successfully";
    }



    //ticket booking logic
    public String bookTicket2(Ticket ticket) {
        String busNumber = ticket.getBusNumber();
        int passengers = ticket.getNumberOfPassengers();
        String email = ticket.getEmailId();

        Bus bus = busRepo.findByBusNumber(busNumber);
        int fare = bus.getFare();
        int seatavail = bus.getSeatAvail();
        int seatleft=seatavail-passengers;

        bus.setSeatAvail(seatleft);
        busRepo.save(bus);

        int totalfare = passengers*fare;
        ticket.setFare(totalfare);
        ticketRepo.save(ticket);


        return "Ticket Booked Successfully." +
                "\nHere are the following details:\n" + "emai id:" + email + "\nBus Number: "
                + busNumber + "\n Number of passengers allowed: " + passengers +
                "\nTotal price:" + totalfare;



    }
}
