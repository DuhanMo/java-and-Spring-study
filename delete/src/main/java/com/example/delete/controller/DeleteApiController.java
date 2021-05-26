package com.example.delete.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {
    // 쿼리파라미터 ?key=value 이거를 @RequestParam으로 받음
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable(name = "userId") Long id, @RequestParam String account) {

        System.out.println(id);
        System.out.println(account);
    }
}
