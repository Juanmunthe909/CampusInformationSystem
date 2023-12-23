package com.project_javaee.java_ee.repository;

import com.project_javaee.java_ee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositories extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);
}
