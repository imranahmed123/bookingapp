package com.bookingapp.theaterservice.repository;

import com.bookingapp.theaterservice.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
