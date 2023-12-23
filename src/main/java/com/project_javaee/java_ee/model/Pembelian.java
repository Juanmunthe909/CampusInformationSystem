package com.project_javaee.java_ee.model;

import jakarta.persistence.*;

@Entity
public class Pembelian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kaos_id", nullable = false)
    private Kaos kaos;

    private String paymentMethod;
    private double paidAmount;

    public Pembelian() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kaos getKaos() {
        return kaos;
    }

    public void setKaos(Kaos kaos) {
        this.kaos = kaos;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }
}
