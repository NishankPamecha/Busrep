package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Buses")
public class Bus {
    @Id
    private String id;
    @Indexed(unique = true)
    private String busNumber;
    private int fare;
    private int maxSeats;
    private int seatAvail;
    private String date;
    private String startLocation;
    private String stopLocation;
}
