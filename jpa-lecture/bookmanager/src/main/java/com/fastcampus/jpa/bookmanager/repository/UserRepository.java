package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // spring data jpa가 지원해주는 부분 <> 제네릭의 값은 엔티티의 값, id의 데이터타입
}
