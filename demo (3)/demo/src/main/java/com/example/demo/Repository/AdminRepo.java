package com.example.demo.Repository;

import com.example.demo.Models.Admin;
import com.example.demo.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends MongoRepository<Admin , String> {

    @Query("{'email': ?0}")
    Admin findByEmail(String emailId);
}
