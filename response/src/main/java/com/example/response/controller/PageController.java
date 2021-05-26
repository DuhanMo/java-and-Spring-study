package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // 원래대로라면 PageController에서는 json을 내려보내지않는다..
    // 여기서는 리턴이 스트링이되면 자동으로 리소스에 html파일을 찾아주는데
    // 여기서 json을 내려주려면 어떻게하냐 ?
    // 1. ResponseEntity
    @ResponseBody // ResponseEntity를 만들어서 내려주겠다
    @GetMapping("/user")
    public User user() {
        var user = new User(); // var로 타입추론
        user.setName("steve");
        user.setAddress("인천광역시");
        // 설정하지않은값은 null 로 보내주는데 null을 포함하지않고 보내겠다 하면 JsonInclude를 이용
        return user;
    }
}
