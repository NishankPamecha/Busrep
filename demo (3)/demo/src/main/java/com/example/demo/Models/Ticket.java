package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tickets")
public class Ticket {

    @Id
    private String id;
    private String firstName;
    private  String lastname;
    private String emailId;
    private String busNumber;
    private int numberOfPassengers;
    private int fare;

}
