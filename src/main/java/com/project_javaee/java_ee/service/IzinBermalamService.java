package com.project_javaee.java_ee.service;

import com.project_javaee.java_ee.model.IzinBermalam;
import com.project_javaee.java_ee.repository.IzinBermalamRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class IzinBermalamService {
    @Autowired
    private IzinBermalamRepositories izinBermalamRepositories;

    public List<IzinBermalam> getAllIzinBermalam() {
        return izinBermalamRepositories.findAll();
    }

    public IzinBermalam getIzinBermalamById(Long id) {
        return izinBermalamRepositories.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Izin Bermalam not found with id " + id));
    }

    public IzinBermalam requestIzinBermalam(IzinBermalam izinBermalam) {
        validateRequestTime(izinBermalam);
        izinBermalam.setApprove("PENDING");
        return izinBermalamRepositories.save(izinBermalam);
    }

    public IzinBermalam approveIzinBermalam(Long id) {
        IzinBermalam izinBermalam = getIzinBermalamById(id);
        izinBermalam.setApprove("Approved");
        return izinBermalamRepositories.save(izinBermalam);
    }

    public IzinBermalam cancelIzinBermalam(Long id) {
        IzinBermalam izinBermalam = getIzinBermalamById(id);
        izinBermalam.setApprove("Cancelled");
        return izinBermalamRepositories.save(izinBermalam);
    }

    private void validateRequestTime(IzinBermalam izinBermalam) {
        // Extract the relevant fields from the izinBermalam object
        String jamPergiString = izinBermalam.getJamPergi();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Parse the jamPergiString into a LocalDateTime object
        LocalDateTime jamPergi = LocalDateTime.parse(jamPergiString, formatter);

        System.out.println("Day of the week: " + jamPergi.getDayOfWeek());
        System.out.println("Hour of the day: " + jamPergi.getHour());

        if (jamPergi.getDayOfWeek() == DayOfWeek.FRIDAY && jamPergi.getHour() < 17) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ 'status' : 500, 'error' : 'Izin Bermalam hanya dapat diajukan di Hari Jumat dan Sabtu'}");
        }

        if (jamPergi.getDayOfWeek() == DayOfWeek.SATURDAY && (jamPergi.getHour() < 8 || jamPergi.getHour() >= 17)) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ 'status' : 500, 'error' : 'Izin Bermalam hanya dapat diajukan di Hari Jumat dan Sabtu'}");
        }
    }
}
