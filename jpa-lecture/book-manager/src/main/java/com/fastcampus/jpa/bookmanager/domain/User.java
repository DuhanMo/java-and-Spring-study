package com.fastcampus.jpa.bookmanager.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 * @author Martin
 * @since 2021/03/10
 */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
//@EntityListeners(value = {MyEntityListener.class, UserEntityListener.class})
@EntityListeners(value = {AuditingEntityListener.class, UserEntityListener.class})
// 여기의 제약사항은 실제 DB와 다를 수 있음 , 즉 실제 DB에 인덱스 설정이 없는데 JPA에서 이런 제약사항을 걸어준다 해도
// 작동이 되지 않음. 실제로는 잘 쓰지 않는다.
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User implements Auditable {
    @Id
    @GeneratedValue
    private Long id;


    @NonNull
    private String name;
// insertable, updatable -> 일반적인 DML에도 영향을 끼침
    @NonNull
    @Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING) // 이걸 안하고 ordinal로 하게되면 잠재적 버그발생
    private Gender gender;

//    @Column(name = "crtd_dt") 과거 모음을 많이 뺐던 DB컬럼명
//    @Column(nullable = false) //  DDL 쿼리를 자동 생성할 때 NOT NULL 을 자동으로 해주는 속성
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
//    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // 데이터에 대한 객체이기때문에 DB레코즈값을 그대로 반영, 반면 별개의 데이터로 소유하고싶은 이슈도 생김
//    @Transient // 이럴 때 쓰는 어노테이션 -> 영속성 처리에서 제외되기 때문에 DB에 반영되지 않고 해당 객체와의 생명주기를 같이함 select,.. 다 안됨
//    private String testDate;


// 현업에서 가장 많이 쓰이는 엔티티리스너 -> prepersist preupdate
//    @PrePersist
//    public void prePersist() {
////        System.out.println(">>>prePersist");
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
////        System.out.println(">>>preUpdate");
//        this.updatedAt = LocalDateTime.now();
//    }

}