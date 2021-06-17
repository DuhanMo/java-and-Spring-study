package com.example.cleanbookmanager.repository;

import com.example.cleanbookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
