package com.project_javaee.java_ee.service;

import com.project_javaee.java_ee.model.Kaos;
import com.project_javaee.java_ee.model.Pembelian;
import com.project_javaee.java_ee.repository.KaosRepositories;
import com.project_javaee.java_ee.repository.PembelianRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembelianService {
    @Autowired
    private PembelianRepositories pembelianRepositories;

    @Autowired
    private KaosRepositories kaosRepositories;

    public void makePayment(Pembelian pembelian) {
        Kaos kaos = kaosRepositories.findBySize(pembelian.getKaos().getSize());

        if (kaos == null) {
            throw new RuntimeException("Invalid kaos size");
        }

        if (pembelian.getPaidAmount() >= kaos.getPrice()) {
            pembelian.setKaos(kaos);

            pembelianRepositories.save(pembelian);
        } else {
            throw new RuntimeException("Payment amount is insufficient");
        }
    }

    public List<Pembelian> getAllPembelian() {
        return pembelianRepositories.findAll();
    }
}
