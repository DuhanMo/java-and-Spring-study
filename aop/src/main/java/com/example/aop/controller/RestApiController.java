package com.example.aop.controller;

import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id + " " + name;
    }
    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }
    @Timer // 직접만들어준 Timer Annotation
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // db logic 1초에서 2초가 걸린다고 했을 때.
        Thread.sleep(1000 * 2);

    }
}
