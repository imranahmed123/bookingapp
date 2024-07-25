package com.bookingapp.theaterservice.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long theaterId;
    private Long movieId;
    private String showTime;
    private int availableSeats;
    // Add the missing method
    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }
}
