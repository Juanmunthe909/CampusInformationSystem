package com.project_javaee.java_ee.controller;

import com.project_javaee.java_ee.model.IzinBermalam;
import com.project_javaee.java_ee.service.IzinBermalamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/izin-bermalam")
public class IzinBermalamController {

    @Autowired
    private IzinBermalamService izinBermalamService;

    @GetMapping("/list")
    public List<IzinBermalam> getAllIzinBermalam() {
        return izinBermalamService.getAllIzinBermalam();
    }

    @GetMapping("/{id}")
    public IzinBermalam getIzinBermalamById(@PathVariable Long id) {
        return izinBermalamService.getIzinBermalamById(id);
    }

    @PostMapping("/request")
    public IzinBermalam requestIzinBermalam(@RequestBody IzinBermalam izinBermalam) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime jamPergi = LocalDateTime.parse(izinBermalam.getJamPergi(), formatter);

        if (!isValidRequestDay(jamPergi)) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ 'status' : 500, 'error' : 'Izin Bermalam hanya dapat diajukan di Hari Jumat dan Sabtu'}");
        }

        return izinBermalamService.requestIzinBermalam(izinBermalam);
    }

    @PutMapping("/approve/{id}")
    public IzinBermalam approveIzinBermalam(@PathVariable Long id) {
        return izinBermalamService.approveIzinBermalam(id);
    }

    @PutMapping("/cancel/{id}")
    public IzinBermalam cancelIzinBermalam(@PathVariable Long id) {
        return izinBermalamService.cancelIzinBermalam(id);
    }

    private boolean isValidRequestDay(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
