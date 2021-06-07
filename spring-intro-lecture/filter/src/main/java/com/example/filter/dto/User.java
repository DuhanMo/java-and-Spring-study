package com.example.filter.dto;

import lombok.*;

//@Getter
//@Setter
@Data // getter,setter,toString,hash 전체 만들어줌
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 생성자
public class User {
    private String name;
    private int age;
}
