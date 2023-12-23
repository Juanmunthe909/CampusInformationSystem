package com.project_javaee.java_ee.service;

import com.project_javaee.java_ee.model.Kaos;
import com.project_javaee.java_ee.repository.KaosRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaosService {
    @Autowired
    private KaosRepositories kaosRepositories;

    public List<Kaos> getAllKaos() {
        return kaosRepositories.findAll();
    }

    public Kaos getKaosById(Long id) {
        return kaosRepositories.findById(id).orElse(null);
    }
}
