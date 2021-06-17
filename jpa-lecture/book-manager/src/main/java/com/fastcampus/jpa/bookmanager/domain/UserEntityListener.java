package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.repository.UserHistoryRepository;
import com.fastcampus.jpa.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

//@Component EntityListener는 spring bean을 주입받지 못함
public class UserEntityListener {
    //    @Autowired
//    private UserHistoryRepository userHistoryRepository; UserEntityListener는 Bean주입이 안되기 때문에 Autowired, Component가 안된다

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();

        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmial(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}


