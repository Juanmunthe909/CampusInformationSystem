package com.project_javaee.java_ee.controller;

import com.project_javaee.java_ee.model.Kaos;
import com.project_javaee.java_ee.service.KaosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kaos")
public class KaosController {
    @Autowired
    private KaosService kaosService;

    @GetMapping
    public List<Kaos> getALlKaos() {
        return kaosService.getAllKaos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kaos> getKaosById(@PathVariable Long id) {
        try {
            Kaos kaos = kaosService.getKaosById(id);
            return ResponseEntity.ok(kaos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
