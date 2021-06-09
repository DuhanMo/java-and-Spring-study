package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;



class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("moduhan@naver.com");
        user.setName("MoDuHan");

        User allArgUser = new User(null,"james", "james95@gmail.com", LocalDateTime.now(), LocalDateTime.now());
        User ReqArgUser = new User("steve", "steve@test.com");
        User user3 = User.builder()
                .name("martin")
                .email("martin@test.com")
                .build();

        System.out.println(">>>" + user);
        System.out.println(">>>" + allArgUser);
    }
}