package com.example.filter.controller;

import com.example.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // java를 위한 시스템로그 --> 롬복을 쓴다면 사용할 수 있음
@RestController
@RequestMapping("/api/user")
public class ApiController {

    @PostMapping("")
    public User user(@RequestBody User user) {
        log.info("User : {},{}",user, user); // 롬복사용하여 로그를 쓸 수 있음
        // 현업에 가면 로그를 json포맷으로 바꿀수도 있고 다양한 경우가 있음
        return user;
        // 이런상황에서 필터를 어떻게 적용시키는가? --> 필터패키지
    }
}
