package com.example.demo.Repository;

import com.example.demo.Models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends MongoRepository<Ticket, String> {
    List<Ticket> findTicketByFirstName(String firstname);

    @Query("{'emailId': ?0}")
    List<Ticket> findTicketByEmailId(String emailId);
}
