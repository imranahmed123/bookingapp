package com.bookingapp.theaterservice.controller;

import com.bookingapp.theaterservice.entity.Show;
import com.bookingapp.theaterservice.entity.Theater;
import com.bookingapp.theaterservice.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping
    public ResponseEntity<Theater> createTheatre(@RequestBody Theater theater) {
        Theater createdTheater = theaterService.createTheater(theater);
        return ResponseEntity.ok(createdTheater);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody Theater theater) {
        Theater updatedTheater = theaterService.updateTheater(id, theater);
        return ResponseEntity.ok(updatedTheater);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        Theater theater = theaterService.getTheaterById(id);
        return ResponseEntity.ok(theater);
    }

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters() {
        List<Theater> theaters = theaterService.getAllTheaters();
        return ResponseEntity.ok(theaters);
    }

    @PostMapping("/{id}/shows")
    public ResponseEntity<Show> createShow(@PathVariable Long id, @RequestBody Show show) {
        show.setTheaterId(id);
        Show createdShow = theaterService.createShow(show);
        return ResponseEntity.ok(createdShow);
    }

    @PutMapping("/shows/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody Show show) {
        Show updatedShow = theaterService.updateShow(id, show);
        return ResponseEntity.ok(updatedShow);
    }

    @DeleteMapping("/shows/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        theaterService.deleteShow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/shows")
    public ResponseEntity<List<Show>> getShowsByTheatreId(@PathVariable Long id) {
        List<Show> shows = theaterService.getShowsByTheaterId(id);
        return ResponseEntity.ok(shows);
    }

    @GetMapping("/shows/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = theaterService.getShowById(id);
        return ResponseEntity.ok(show);
    }
}
