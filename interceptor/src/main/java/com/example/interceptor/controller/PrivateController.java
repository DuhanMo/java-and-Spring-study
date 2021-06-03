package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Auth
@Slf4j
// 인터셉터에서 세션을 검사해서 auth가 있으면 통과, 없으면 막힘
public class PrivateController {
    @GetMapping("/hello")
    public String hello() {
        log.info("private hello controller");
        return "private hello";
    }

}
