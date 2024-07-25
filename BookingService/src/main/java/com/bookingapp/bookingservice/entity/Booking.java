package com.bookingapp.bookingservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long showId;
    private int seatsBooked;
    private LocalDateTime bookingTime;
    private double totalAmount;
}
