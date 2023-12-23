package com.project_javaee.java_ee.service;

import com.project_javaee.java_ee.model.Surat;
import com.project_javaee.java_ee.repository.SuratRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuratService {
    @Autowired
    private SuratRepositories suratRepositories;

    public List<Surat> getAllSurat() {
        return suratRepositories.findAll();
    }

    public List<Surat> getUnapprovedSurat() {
        return suratRepositories.findAllByStatus("PENDING");
    }

    public ResponseEntity<String> validateSurat(Surat surat) {
        if (surat.getKeterangan() == null || surat.getTanggal() == null) {
            return ResponseEntity.badRequest().body("Keterangan dan Tanggal surat harus diisi.");
        }
        return ResponseEntity.ok("Data surat valid.");
    }
}
