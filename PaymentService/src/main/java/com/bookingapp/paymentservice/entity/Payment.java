package com.bookingapp.paymentservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookingId;
    private Long userId;
    private Double amount;
    private String paymentStatus;
    private LocalDateTime paymentTime;
}
