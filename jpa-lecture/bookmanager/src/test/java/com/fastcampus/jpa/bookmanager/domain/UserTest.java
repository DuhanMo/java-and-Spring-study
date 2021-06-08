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

        User allArgUser = new User("james", "james95@gmail.com", LocalDateTime.now(), LocalDateTime.now());
        User ReqArgUser = new User("steve", "steve@test.com");

        System.out.println(">>>" + user);
        System.out.println(">>>" + allArgUser);
    }
}