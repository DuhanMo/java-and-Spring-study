package com.example.cleanbookmanager.repository;

import com.example.cleanbookmanager.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
