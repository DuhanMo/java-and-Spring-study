package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    // 매핑한것과 파라미터는 이름이 똑같아야함
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable : " + pathName);

        return pathName;
    }
    @GetMapping("/path-variable/{name}/{age}")
    public String pathVariableDto(UserRequest request) {
        System.out.println("유저의 이름은? : " + request.getName());
        System.out.println("유저의 나이는? : " + request.getAge());

        return request.getName() + " , " + request.getAge();
    }
    // 쿼리파라미터 주로 검색할때 사용
    // search?q=intellij
    // &rlz=1C5CHFA_enKR914KR914
    // &oq=intellij
    // &aqs=chrome.0.69i59j69i60j69i61.1727j0j7
    // &sourceid=chrome
    // &ie=UTF-8

    // ?key=value&key2=value2
    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue()+"\n");

        });
        return sb.toString();
    }

    // Map으로 받으면 모든 Key를 받을 수 있지만 Key값이 뭔지 모름
    // 그래서 명시적으로 RequestParam으로 다 선언을 해줌
    // 하지만 파라미터가 많아진다면?
    // 모든 걸 다 쓸수 없기때문에 스프링은 DTO 형식을 지원해준다
    @GetMapping("/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }
    //현업에서 제일 많이쓰는 방법 DTO 방법
    // @RequestParam 이라는 어노테이션을 붙이지 않는다.
    // 스프링부트 작동 원리
    // 파라미터로 객체를 넣어놓으면 (여기선 UserRequest)
    // 쿼리파라미터로 들어온 값을 자동으로 매핑해준다.
    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
