package com.example.demo.Repository;

import com.example.demo.Models.Ticket;
import com.example.demo.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    @Query("{'email': ?0}")
    User findByEmail(String emailId);
}
