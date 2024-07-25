package com.bookingapp.theaterservice.repository;

import com.bookingapp.theaterservice.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByTheaterId(Long theaterId);
}
