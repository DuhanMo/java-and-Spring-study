package com.example.cleanbookmanager.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setName("moduhan");
        user.setEmail("moduhan@gmail.com");
        user.setGender(Gender.MALE);

        User user2 = User.builder()
                .email("user2@test.com")
                .name("testName")
                .gender(Gender.FEMALE)
                .build();

        System.out.println(user);
        System.out.println(user2);
    }
}