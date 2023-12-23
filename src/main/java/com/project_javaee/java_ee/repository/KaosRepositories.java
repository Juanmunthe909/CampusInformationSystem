package com.project_javaee.java_ee.repository;

import com.project_javaee.java_ee.model.Kaos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaosRepositories extends JpaRepository<Kaos, Long> {
    Kaos findBySize(String size);
}
