package com.project_javaee.java_ee.controller;

import com.project_javaee.java_ee.model.Surat;
import com.project_javaee.java_ee.repository.SuratRepositories;
import com.project_javaee.java_ee.service.SuratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surat")
public class SuratController {
    @Autowired
    private SuratRepositories suratRepositories;

    @Autowired
    private SuratService suratService;

    @PostMapping("/request")
    public ResponseEntity<String> requestSurat(@RequestBody Surat surat) {
        ResponseEntity<String> validationResponse = suratService.validateSurat(surat);
        if (validationResponse.getStatusCode().isError()) {
            return validationResponse; // Return validation error response
        }

        surat.setStatus("PENDING");
        suratRepositories.save(surat);
        return ResponseEntity.ok("Surat berhasil direquest.");
    }

    @GetMapping("/approve/{suratId}")
    public ResponseEntity<String> approveSurat(@PathVariable Long suratId) {
        Optional<Surat> suratOptional = suratRepositories.findById(suratId);
        if (suratOptional.isPresent()) {
            Surat surat = suratOptional.get();
            surat.setStatus("Approved");
            suratRepositories.save(surat);
            return ResponseEntity.ok("Surat berhasil diapprove.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cancel/{suratId}")
    public ResponseEntity<String> cancelSurat(@PathVariable Long suratId) {
        Optional<Surat> suratOptional = suratRepositories.findById(suratId);
        if (suratOptional.isPresent()) {
            Surat surat = suratOptional.get();
            surat.setStatus("Cancelled");
            suratRepositories.save(surat);
            return ResponseEntity.ok("Surat berhasil dibatalkan.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public List<Surat> getAllSurat() {
        return suratRepositories.findAll();
    }

    @Controller
    @RequestMapping("/surats")
    class SuratPageController {

        @GetMapping("/surat")
        public String showSuratPage() {
            return "surat";
        }
    }
}
