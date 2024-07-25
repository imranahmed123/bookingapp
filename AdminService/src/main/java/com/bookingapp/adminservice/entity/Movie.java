package com.bookingapp.adminservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String language;
    private int duration;
}
