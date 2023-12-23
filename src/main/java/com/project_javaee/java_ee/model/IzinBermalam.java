package com.project_javaee.java_ee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IzinBermalam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jamPergi;
    private String jamPulang;
    private String keterangan;
    private String lokasi;
    private String approve;

    public IzinBermalam() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJamPergi() {
        return jamPergi;
    }

    public void setJamPergi(String jamPergi) {
        this.jamPergi = jamPergi;
    }

    public String getJamPulang() {
        return jamPulang;
    }

    public void setJamPulang(String jamPulang) {
        this.jamPulang = jamPulang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }
}
