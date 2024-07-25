package com.bookingapp.movieservice.repository;

import com.bookingapp.movieservice.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
