package com.example.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@SpringBootApplication // 빈으로 만들어서 싱글톤형태로 관리한다.
public class SpringIocApplication {

    public static void main(String[] args) {
        // 스프링어플리케이션이 실행되고 나면 가져오도록 함
        SpringApplication.run(SpringIocApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext(); // context를 가져옴

        // Bean을 찾는 방법은 여러가지가 있다.
        // Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        // UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

//        Encoder encoder = new Encoder(base64Encoder);
//        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
//
//        String result = encoder.encode(url);
//        System.out.println(result);
//
//        encoder.setIEncoder(urlEncoder);
//        result = encoder.encode(url);

        Encoder encoder = context.getBean("base64Encode",Encoder.class);

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result = encoder.encode(url);

        System.out.println(result);

    }
}

@Configuration // 한개의 클래스에서 여러개의 빈을 등록할거다! 라는 뜻
class AppConfig{
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }
    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}
