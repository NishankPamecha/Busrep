package com.example.demo.Controller;

import com.example.demo.Models.Bus;
import com.example.demo.Repository.BusRepo;
import com.example.demo.Services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private BusService busService;

    //adding new buses
    @PostMapping("/add")
    public ResponseEntity<String> addNewBus(@RequestBody Bus bus){

        return new ResponseEntity<String>(busService.addBus(bus), HttpStatus.OK);
    }

    //finding all the buses
    @GetMapping("/")
    public ResponseEntity<List<Bus>> getAllBuses(){
        return new ResponseEntity<List<Bus>>(busService.getAllBuses(), HttpStatus.OK);
    }

    //custom method
    @GetMapping("/busnumber/{busNumber}")

    public ResponseEntity<Bus> getBus(@PathVariable(value = "busNumber") String busnumber){
        return new ResponseEntity<Bus>(busService.getBusByNumber(busnumber), HttpStatus.OK);
    }

    //byid
    @GetMapping("/busbyid/{id}")
    public Optional<Bus> getBusById(@PathVariable String id){
        return busRepo.findById(id);
    }


    //delete by id
    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable String id){
        return new ResponseEntity<String>(busService.deleteBus(id), HttpStatus.OK);
    }


    //filter buses based on start and stop location
    @GetMapping("/startstop/{startLocation}/{stopLocation}")
    public ResponseEntity<List<Bus>> findBusByStartStop(@PathVariable(value = "startLocation") String startLocation,
                                                        @PathVariable(value = "stopLocation") String stopLocation){
        return new ResponseEntity<List<Bus>>(busRepo.findByStartStopLoc(startLocation, stopLocation), HttpStatus.OK);
    }


}
