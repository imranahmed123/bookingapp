package com.bookingapp.showservice.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long theatreId;
    private Long movieId;
    private String showTime;
    private int availableSeats;
}
