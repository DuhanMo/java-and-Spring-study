package com.fastcampus.jpa.bookmanager.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

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

    @Test
    void crud2() {
//        userRepository.save(new User("moduhan", "moduhan@test.com"));
//        userRepository.flush(); // 디비에 저장되는 시점을 조작하는 것으로 쿼리문에서는 변화를 볼 수 없다.
//        userRepository.findAll().forEach(System.out::println);

//        long count = userRepository.count();
//        System.out.println(count);

//        boolean exist = userRepository.existsById(1L);
//        System.out.println(exist);

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(2L); // delete를 하기전 select쿼리를 실행하여 실제 값이 존재하는지 파악
//
//        userRepository.findAll().forEach(System.out::println);


//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L))); 성능이슈 존재 (모든 행마다 delete를 실행하기 때문에) -> deleteInBatch를 씀
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
        // Batch 메소드 쓸 경우 한번의 delete문만 실행
//        userRepository.findAll().forEach(System.out::println);

        //페이징
//        Page<User> users = userRepository.findAll(PageRequest.of(0, 3));
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

        // 엔티티를 example로 만들고 matcher를 추가해서 선언함으로써 필요한 쿼리를 만드는 방법
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name") // 매칭에서 제외시키겠다. name은 제외시키겠다
                .withMatcher("email", endsWith());

        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);

        User user = new User();
        user.setEmail("slow");
        ExampleMatcher matcher1 = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example1 = Example.of(user, matcher1);

        userRepository.findAll(example1).forEach(System.out::println);
    }

}