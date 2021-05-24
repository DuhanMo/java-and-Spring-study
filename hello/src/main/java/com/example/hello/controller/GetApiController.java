package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // path 는 명확하게 경로가 hello 이다 라고 지저해주는 것
    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String hello() {
        return "get Hello";
    }

    // RequestMapping 은 get. post, put, delete 를 다 쓸 수 있음. 그래서
    // RequestMapping 와 GET 메소드를 합친것이 GetMapping
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // /get /post /put /delete
    public String hi() {
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}

    @GetMapping("/path-variable")
    public String pathVariable() {

    }
}
