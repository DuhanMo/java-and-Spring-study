package com.example.cleanbookmanager.repository;

import com.example.cleanbookmanager.domain.Gender;
import com.example.cleanbookmanager.domain.User;
import com.example.cleanbookmanager.domain.UserHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Test
    void crud() {
        User user = User.builder()
                .email("user@test.com")
                .name("testName")
                .gender(Gender.FEMALE)
                .build();
        User user2 = new User();

        userRepository.save(user);
        userRepository.save(user2);

        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void updateStampTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@fastcapmus.com");

        userRepository.save(user);
        System.out.println("업데이트 전 >>>" + userRepository.findById(1L));


        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrrtin");

        userRepository.save(user2);
        System.out.println("업데이트 후 >>>" + userRepository.findById(1L));

    }
    @Test
    void userHistoryRepositoryTest() {
        User user = new User();
        user.setName("user입니다");
        user.setEmail("user@Email.com");

        userRepository.save(user);

        user.setName("user업데이트됐습니다");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }
    @Test
    void select() {
        userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void userHistoryTest() {
        User user = new User();
        user.setName("두한");
        user.setGender(Gender.MALE);
        user.setEmail("duhan@test.com");

        userRepository.save(user);

        user.setName("두한update");
        userRepository.save(user);
        user.setName("두한updateUpdate");
        userRepository.save(user);


//        List<UserHistory> result = userHistoryRepository
//                .findByUserId(userRepository.findByEmail("duhan@test.com").getId());

        List<UserHistory> result = userRepository.findByEmail("duhan@test.com").getUserHistories();

        result.forEach(System.out::println);
        System.out.println("=============");

        System.out.println(userHistoryRepository.findAll().get(2).getUser());
    }
}