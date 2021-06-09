package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@ToString // toString()을 오버라이딩 해주는 롬복 어노테이션
@Getter //getter와 setter를 만들어주는 롬복의 어노테이션
@Setter
@NoArgsConstructor // 인자를 주지않고 new User로 생성하는 생성자 , JPA에서는 인자가 없는 생성자가 꼭 필요함
@AllArgsConstructor // 모든 필드를 인자로 받아서 생성하는 생성자
@RequiredArgsConstructor // 꼭 필요한 인자만을 받아서 생성해주는 생서자, 지금은 NoArgsConstructor와 같은 역할을함
// @Data 는 기본적으로 Required를 제공해준다. Nonnull이나 final이 없으면 NoArgsCons로 작동한다.
// 그렇다고 RequiredArgsConstructor 만쓴다면 추후에 에러발생할 수 있음. 기본 생성자가 꼭필요하기때문에 @NoArgs를 꼭 써줘라
// JPA에서는 hashCode 를 많이 쓰진않지만 @Data에서 지원하기때문에 알아두길 권장.
// equals, hashCode, toString을 모두 오버라이딩하는것이 좋다.
@EqualsAndHashCode
@Data // 엄청 많은 역할을 하는것같지만 OOP를 깨는 역할을 종종하기때문에 완벽한 어노테이션은 아님.
@Builder // AllArgsConstructor와 비슷하게 객체를 생성하고 필드를 주입하는데 builder의 형식을 제공
@Entity // Entity에는 프라이머리키가 반드시 필요함
public class User {
    @Id // 이 앤티티의 프라이머리키가 됨

    @GeneratedValue // id 라는 숫자는 자동으로 증가하는 숫자값
    private Long id;
    @NonNull // 이제 name을 필수적으로 넣어야 한다.
    private String name;
    @NonNull // RequiredArgsConstructor 이 작동됨
    private String email;
    // 일반적으로 create, update 시각은 jpa 도메인 객체에는 항상 포함되어있어야 한다.
    // 데이터베이스의 데이터가 언제 추가되고 수정되었는지 확인하기 위해
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
// 앞으로 쓸 엔티티라는 객체는 필드구조와 게터 세터와 만들어짐
// jpa에서 사용하는 엔티티에서는 컬럼이 필드로 표현됨. 컬럼이 많아질 수록 getter,setter등 훨씬 많아지게 되고
// 코드가 지저분해지기 때문에 롬복을 사용

