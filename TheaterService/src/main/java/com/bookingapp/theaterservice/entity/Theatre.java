package com.example.theatreservice.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int capacity;
}
