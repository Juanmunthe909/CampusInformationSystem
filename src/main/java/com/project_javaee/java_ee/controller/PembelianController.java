package com.project_javaee.java_ee.controller;

import com.project_javaee.java_ee.model.Pembelian;
import com.project_javaee.java_ee.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pembelian")
public class PembelianController {
    @Autowired
    private PembelianService pembelianService;

    @PostMapping("/payment")
    public ResponseEntity<String> makePayment(@RequestBody Pembelian pembelian) {
        try {
            pembelianService.makePayment(pembelian);
            return ResponseEntity.ok("Payment successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public List<Pembelian> getAllPembelian() {
        return pembelianService.getAllPembelian();
    }
}
