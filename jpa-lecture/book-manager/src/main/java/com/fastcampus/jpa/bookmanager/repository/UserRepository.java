package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.User;
import jdk.vm.ci.meta.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

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

    User findTop1ByName(String name);

    List<User> findByNameAndEmail(String name, String email);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByCreatedAtAfter(LocalDateTime time);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime time);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime time);

    List<User> findByCreatedAtBetween(LocalDateTime time1, LocalDateTime time2);

    List<User> findByIdBetween(Long id1, Long id2);





}
