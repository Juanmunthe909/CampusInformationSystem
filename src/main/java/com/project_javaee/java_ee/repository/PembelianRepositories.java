package com.project_javaee.java_ee.repository;

import com.project_javaee.java_ee.model.Pembelian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembelianRepositories extends JpaRepository<Pembelian, Long> {
}
