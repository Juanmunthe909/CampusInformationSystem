package com.project_javaee.java_ee.service;

import com.project_javaee.java_ee.model.User;
import com.project_javaee.java_ee.repository.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositories userRepositories;

    public User registerUser(User user) {
        if (userRepositories.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken.");
        }
        user.setRole("user");

        return userRepositories.save(user);
    }

    public User authenticate(String username, String password) {
        Optional<User> userOptional = userRepositories.findByUsernameAndPassword(username, password);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepositories.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
