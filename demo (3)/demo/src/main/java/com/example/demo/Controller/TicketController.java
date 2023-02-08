package com.example.demo.Controller;

import com.example.demo.Models.Bus;
import com.example.demo.Models.Ticket;
import com.example.demo.Repository.TicketRepo;
import com.example.demo.Services.BusService;
import com.example.demo.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepo ticketRepo;

    //new ticket
    @PostMapping("/add")
    public ResponseEntity<String> addNewTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<String>(ticketService.bookTicket(ticket), HttpStatus.OK);
    }


    //all the tickets
    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        return new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(), HttpStatus.OK);
    }


    //specific ticket by id
    @GetMapping("/ticketbyid/{id}")
    public Optional<Ticket> getTicketById(@PathVariable String id){
        return ticketService.findTicketById(id);
    }


    //cancel the ticket
    @DeleteMapping("/cancel-ticket/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable String id){
        return new ResponseEntity<String>(ticketService.deleteTicket(id), HttpStatus.OK);
    }


    //custom method
    @GetMapping("/email/{emailId}")
    public ResponseEntity<List<Ticket>> getTicketByEmail(@PathVariable(value = "emailId") String emailId){
        return new ResponseEntity<List<Ticket>>(ticketRepo.findTicketByEmailId(emailId), HttpStatus.OK);
    }


    //Ticketbooking
    @PostMapping("/bookticket")
    public ResponseEntity<String> bookTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<String>(ticketService.bookTicket2(ticket), HttpStatus.OK);
    }





}
