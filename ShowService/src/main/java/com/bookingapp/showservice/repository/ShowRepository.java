package com.bookingapp.showservice.repository;

import com.bookingapp.showservice.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByTheatreId(Long theatreId);
}
