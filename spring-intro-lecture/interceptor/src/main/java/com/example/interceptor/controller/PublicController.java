package com.example.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 아무런 권한이 없는 , 권한있는 모든 사용자가 접근가능한 컨트롤러
// privateCtr 과 publicCtr 을 어떻게 구분할 것인가?
@RestController
@RequestMapping("/api/public")
public class PublicController {
    @GetMapping("/hello")
    public String hello() {
        return "public hello";
    }
}
