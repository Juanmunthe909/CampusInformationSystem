package com.project_javaee.java_ee.controller;

import com.project_javaee.java_ee.model.Booking;
import com.project_javaee.java_ee.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public Booking bookRoom(@RequestBody Booking booking) {
        booking.setStatus("PENDING");

        return bookingService.bookRoom(booking);
    }

    @GetMapping("/list")
    public List<Booking> getAllRooms() {
        return bookingService.getAllRooms();
    }

    @PutMapping("/approve/{id}")
    public String approveBooking(@PathVariable Long id) {
        try {
            bookingService.approveBooking(id);
            return "Booking approved successfully";
        } catch (Exception e) {
            return "Error approving booking: " + e.getMessage();
        }
    }

    @PutMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
            return "Booking canceled successfully";
        } catch (Exception e) {
            return "Error canceling booking: " + e.getMessage();
        }
    }
}
