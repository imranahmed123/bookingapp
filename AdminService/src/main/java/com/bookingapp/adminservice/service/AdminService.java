package com.bookingapp.adminservice.service;

import com.bookingapp.adminservice.entity.Movie;
import com.bookingapp.adminservice.entity.Show;
import com.bookingapp.adminservice.entity.Theatre;
import com.bookingapp.adminservice.repository.MovieRepository;
import com.bookingapp.adminservice.repository.ShowRepository;
import com.bookingapp.adminservice.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    // Movie operations
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Show operations
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

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    // Theatre operations
    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheatre(Long id, Theatre theatre) {
        theatre.setId(id);
        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }

    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id).orElse(null);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }
}
