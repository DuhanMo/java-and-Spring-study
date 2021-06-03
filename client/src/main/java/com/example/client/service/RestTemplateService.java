package com.example.client.service;

import com.example.client.dto.UserRequest;
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
        // getForEntity 는 가져오겠다의 get 이 아니라 HttpMethod의 Get 메소드임
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode()); // res의 상태코드
        System.out.println(result.getBody()); // res의 내용
        return result.getBody();

    }

    public UserResponse post() {

        // http://localhost:9090/api/server/user/{userId}/name/{userName} --> user를 등록시키는 uri 예제일뿐 실제로
        // 이렇게 사용하진 않음
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "postSteve") // 위 {} 에 자동으로 매핑됨
                .toUri();
        System.out.println(uri);
        // Post 이기때문에 Http Body가 있어야 함
        // object -> object mapper -> json -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("james2");
        req.setAge(97);


        RestTemplate restTemplate = new RestTemplate();

        // uri, 보내고싶은 객체와 받고싶은 타입
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req,UserResponse.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());


        return response.getBody();
    }
}
