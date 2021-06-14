package com.fastcampus.jpa.bookmanager.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Martin
 * @since 2021/03/10
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
    void crud() { // create, read, update, delete
//        보통 List 타입은 변수명 선언할 때 복수형으로 선언함
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name")); // 기존은 id순 소팅한 후 이름 순
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L,3L,5L));
//        users.forEach(System.out::println);

//        User user1 = new User("jack", "jack@fast.com");
//        User user2 = new User("steve", "steve@test.com");
//
//        userRepository.saveAll(Lists.newArrayList(user1, user2)); // 테스트에서 제공해주는 Assertion 에서 List를 편하게 넣어주는 기능
//
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);
//        User user = userRepository.getOne(1L); // getOne은 기본적으로 엔티티에대해서 레이지한 로딩을 지원해줌
        // getOne을 하고 print시점까지 세션을 유지시켜주려면 @Transactional 어노테이션을 붙여야함

        Optional<User> user = userRepository.findById(1L); // 리턴되는 객체가 Optional로 래핑되어있음
        User user2 = userRepository.findById(1L).orElse(null); // Optional로 감싸지 않아도 됨 orElse를 하면
        System.out.println(user2);
    }

}