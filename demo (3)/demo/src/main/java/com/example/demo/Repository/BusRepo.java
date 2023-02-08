package com.example.demo.Repository;

import com.example.demo.Models.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BusRepo extends MongoRepository<Bus, String> {

    @Query("{'busNumber': ?0}")
    Bus findByBusNumber(String busnumber);


    @Query("{'startLocation': ?0, 'stopLocation': ?1}")
    List<Bus> findByStartStopLoc(String startLocation, String stopLocation);
}
