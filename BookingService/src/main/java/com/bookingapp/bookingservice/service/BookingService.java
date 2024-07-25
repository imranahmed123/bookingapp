package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.entity.Booking;
import com.bookingapp.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
