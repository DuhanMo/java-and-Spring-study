package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// 클라이언트 단의 dto 네임과 달라도됨
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String name;
    private int age;
}
