package com.project_javaee.java_ee.repository;

import com.project_javaee.java_ee.model.Surat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuratRepositories extends JpaRepository<Surat, Long> {
    List<Surat> findAllByStatus(String status);
}
