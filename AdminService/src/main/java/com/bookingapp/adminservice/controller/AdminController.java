package com.bookingapp.adminservice.controller;

import com.bookingapp.adminservice.entity.Movie;
import com.bookingapp.adminservice.entity.Show;
import com.bookingapp.adminservice.entity.Theatre;
import com.bookingapp.adminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Movie endpoints
    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = adminService.createMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie updatedMovie = adminService.updateMovie(id, movie);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        adminService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = adminService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = adminService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // Show endpoints
    @PostMapping("/shows")
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show createdShow = adminService.createShow(show);
        return ResponseEntity.ok(createdShow);
    }

    @PutMapping("/shows/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody Show show) {
        Show updatedShow = adminService.updateShow(id, show);
        return ResponseEntity.ok(updatedShow);
    }

    @DeleteMapping("/shows/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        adminService.deleteShow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/shows/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = adminService.getShowById(id);
        return ResponseEntity.ok(show);
    }

    @GetMapping("/shows")
    public ResponseEntity<List<Show>> getAllShows() {
        List<Show> shows = adminService.getAllShows();
        return ResponseEntity.ok(shows);
    }

    // Theatre endpoints
    @PostMapping("/theatres")
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre) {
        Theatre createdTheatre = adminService.createTheatre(theatre);
        return ResponseEntity.ok(createdTheatre);
    }

    @PutMapping("/theatres/{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable Long id, @RequestBody Theatre theatre) {
        Theatre updatedTheatre = adminService.updateTheatre(id, theatre);
        return ResponseEntity.ok(updatedTheatre);
    }

    @DeleteMapping("/theatres/{id}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable Long id) {
        adminService.deleteTheatre(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/theatres/{id}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable Long id) {
        Theatre theatre = adminService.getTheatreById(id);
        return ResponseEntity.ok(theatre);
    }

    @GetMapping("/theatres")
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        List<Theatre> theatres = adminService.getAllTheatres();
        return ResponseEntity.ok(theatres);
    }
}
