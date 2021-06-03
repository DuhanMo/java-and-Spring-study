package com.example.client.service;

import com.example.client.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // 요청
    // http://localhost/api/server/hello
    // response
    public UserResponse hello() {
        // 주소를 만들 때 많이 쓰는 방법
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name","james")
                .queryParam("age",39)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        // 문자열로 결과를 받을것이다.
        // getForObject 가 실행되는 순간이 클라이언트에서 Http로 서버와 붙는 순간임
//        String result = restTemplate.getForObject(uri, String.class);

        // 문자열 형태
//        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);


        // 그러면 json형태는 어떻게 받는가?
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode()); // res의 상태코드
        System.out.println(result.getBody()); // res의 내용
        return result.getBody();

    }
}
