package com.project_javaee.java_ee.controller;

import com.project_javaee.java_ee.model.IzinKeluar;
import com.project_javaee.java_ee.repository.IzinKeluarRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/izin-keluar")
public class IzinKeluarController {
    @Autowired
    private IzinKeluarRepositories izinKeluarRepositories;

    @PostMapping("/request")
    public void requestIzinKeluar(@RequestBody IzinKeluar izinKeluar) {
        izinKeluar.setApprove("PENDING");
        izinKeluarRepositories.save(izinKeluar);
    }

    @PutMapping("/approve/{id}")
    public void approveIzinKeluar(@PathVariable Long id) {
        IzinKeluar izinKeluar = izinKeluarRepositories.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Izin Keluar ID"));
        izinKeluar.setApprove("Approved");
        izinKeluarRepositories.save(izinKeluar);
    }

    @PutMapping("/cancel/{id}")
    public void cancelIzinKeluar(@PathVariable Long id) {
        IzinKeluar izinKeluar = izinKeluarRepositories.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Izin Keluar ID"));
        izinKeluar.setApprove("Cancelled");
        izinKeluarRepositories.save(izinKeluar);
    }

    @GetMapping("/list")
    public List<IzinKeluar> getIzinKeluarList() {
        return izinKeluarRepositories.findAll();
    }
}
