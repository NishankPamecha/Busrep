package com.example.demo.Services;

import com.example.demo.Models.Bus;
import com.example.demo.Repository.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepo busRepo;


    public List<Bus> getAllBuses(){
        return busRepo.findAll();
    }

    public String addBus(Bus bus){
        busRepo.save(bus);
        return "Bus added successfully";
    }


    public Bus getBusByNumber(String busnumber) {
       return busRepo.findByBusNumber(busnumber);

    }

    public String deleteBus(String id) {
        busRepo.deleteById(id);
        return "Bus of id "+id+" deleted successfully";
    }
}
