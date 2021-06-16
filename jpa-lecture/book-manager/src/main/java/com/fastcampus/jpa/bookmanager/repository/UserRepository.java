package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.User;
import jdk.vm.ci.meta.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Martin
 * @since 2021/03/10
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name); // 간단한 쿼리메소드. name으로 검색했을 시 여러명이 나올 수잇어 list

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email);

    User findFirst1ByName(String name);

    List<User> findFirst2ByName(String name);

//    User findTop1ByName(String name);

    List<User> findByNameAndEmail(String name, String email);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByCreatedAtAfter(LocalDateTime time);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime time);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime time);

    List<User> findByCreatedAtBetween(LocalDateTime time1, LocalDateTime time2);

    List<User> findByIdBetween(Long id1, Long id2);


    User findTop1ByName(String name);

    User findTop1ByNameOrderByIdDesc(String name);

    // id에 역순 email에 정순
    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);

    // 우리가 조회하려는 데이터 타입
    // 페이지라는 엔티티타입은 Slice를 상속받음 -> 데이터 묶음
    // Pageable 페이징에대한 요청값, Page 는 페이징에대한 응답값
    Page<User> findByName(String name, Pageable pageable);

    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRawRecord(); // 위 쿼리 결과값이 map에 저장되서 리턴 된다
}
