package com.example.cleanbookmanager.repository;

import com.example.cleanbookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
