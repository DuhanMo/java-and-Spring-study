package com.example.cleanbookmanager.domain.listener;


import com.example.cleanbookmanager.domain.User;
import com.example.cleanbookmanager.domain.UserHistory;
import com.example.cleanbookmanager.repository.UserHistoryRepository;
import com.example.cleanbookmanager.support.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersistAndUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();

        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}
