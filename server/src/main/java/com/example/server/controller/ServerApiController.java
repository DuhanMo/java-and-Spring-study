package com.example.server.controller;

import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {
    @GetMapping("/naver")
    public String naver() {
        // https://openapi.naver.com/v1/search/local.json
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com/v1/search/local.json")
                .queryParam("query","갈비집")
                .encode()
                .build()
                .toUri();
        System.out.println(uri);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id","YCkJq1wijWw3hK33uw92")
                .header("X-Naver-Client-Secret","MeTatAqYYm")
                .build();
        System.out.println(requestEntity);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(requestEntity,String.class);
        return result.getBody();
    }

    @GetMapping("/hello")
    public User hello(@RequestParam String name,
                      @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;
    }
    @PostMapping("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String auth,
                     @RequestHeader("custom-authorization") String customAuth){
        log.info("userId : {} , userName : {} ", userId, userName);
        log.info("auth : {} , custom Auth : {}", auth, customAuth);
        log.info("client req : {}", user);

        return user;


    }
}
