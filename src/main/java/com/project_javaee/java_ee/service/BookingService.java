package com.project_javaee.java_ee.service;

import com.project_javaee.java_ee.model.Booking;
import com.project_javaee.java_ee.repository.BookingRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepositories bookingRepositories;

    public Booking bookRoom(Booking booking) {
        List<Booking> conflictingRooms = bookingRepositories.findByStartTimeBetweenAndEndTimeBetween(
                booking.getStartTime(), booking.getEndTime(),
                booking.getStartTime(), booking.getEndTime()
        );

        if (!conflictingRooms.isEmpty()) {
            throw new RuntimeException("Ruangan sudah terbooking pada waktu yang sama.");
        }
        return bookingRepositories.save(booking);
    }

    public List<Booking> getAllRooms() {
        return bookingRepositories.findAll();
    }

    public void approveBooking(Long id) {
        Booking booking = bookingRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("Approved");
        bookingRepositories.save(booking);
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("Cancelled");
        bookingRepositories.save(booking);
    }
}
