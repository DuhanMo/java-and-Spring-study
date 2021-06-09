package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // Spring Context를 로딩해서 테스트에 활용하겠다
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() { // create, read, update, delete
        userRepository.save(new User()); // @NoArgs를 이용해 테이블에 저장하겠다
        // 실제 서비스에서는 findAll 성능이슈때문에 잘 사용하지 않는다.

        System.out.println(">>>" + userRepository.findAll());
    }


}