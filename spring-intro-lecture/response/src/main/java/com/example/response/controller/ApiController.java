package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // JSON
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user; //200 OK
    }

    // 201? 202?
    // Response를 내려줄 때 응답코드를 함께 정해줄것이다 그러기 위해 보내줘야하는 방법이
    // ResponseEntity 를 이용해야함
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        // put을 이용하면 업데이트도 업데이트지만 생성도 가능하다. 이때 201 status를 보내주려면 (생성되었을 때)
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//        return ResponseEntity.ok(user);
        // 수정 되었을 땐 200
//        ResponseEntity.status(HttpStatus.OK);
//        ResponseEntity.ok();


    }

}
