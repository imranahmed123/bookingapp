package com.bookingapp.theaterservice.service;

import com.bookingapp.theaterservice.entity.Show;
import com.bookingapp.theaterservice.entity.Theater;
import com.bookingapp.theaterservice.repository.ShowRepository;
import com.bookingapp.theaterservice.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Theater updateTheater(Long id, Theater theater) {
        theater.setId(id);
        return theaterRepository.save(theater);
    }

    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }

    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).orElse(null);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public Show updateShow(Long id, Show show) {
        show.setId(id);
        return showRepository.save(show);
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }

    public Show getShowById(Long id) {
        return showRepository.findById(id).orElse(null);
    }
    public List<Show> getShowsByTheaterId(Long theaterId) {
        return showRepository.findByTheaterId(theaterId); // Assuming a method in the repository
    }

}
