package com.example.cleanbookmanager.repository;

import com.example.cleanbookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String s);
}
