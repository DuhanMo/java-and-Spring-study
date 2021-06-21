package com.example.cleanbookmanager.repository;

import com.example.cleanbookmanager.domain.User;
import com.example.cleanbookmanager.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
    List<UserHistory> findByUserId(Long userId);

}
