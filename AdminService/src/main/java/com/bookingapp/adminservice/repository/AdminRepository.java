package com.bookingapp.adminservice.repository;

import com.bookingapp.adminservice.entity.Movie;
import com.bookingapp.adminservice.entity.Show;
import com.bookingapp.adminservice.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

public interface ShowRepository extends JpaRepository<Show, Long> {
}

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
