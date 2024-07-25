package com.bookingapp.adminservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long theatreId;
    private Long movieId;
    private LocalDateTime showTime;
    private int availableSeats;
}
