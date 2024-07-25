package com.bookingapp.showservice.controller;

import com.bookingapp.showservice.entity.Show;
import com.bookingapp.showservice.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show createdShow = showService.createShow(show);
        return ResponseEntity.ok(createdShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody Show show) {
        Show updatedShow = showService.updateShow(id, show);
        return ResponseEntity.ok(updatedShow);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id) {
        Show show = showService.getShowById(id);
        return ResponseEntity.ok(show);
    }

    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<List<Show>> getShowsByTheatreId(@PathVariable Long theatreId) {
        List<Show> shows = showService.getShowsByTheatreId(theatreId);
        return ResponseEntity.ok(shows);
    }
}
