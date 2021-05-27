package com.company.ioc;

import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        /*
        // Base64로 인코딩 해주세요 //ioc, DI 전혀 쓰지않음
        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        // url encoding
        UrlEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);
        */

        // 만들때마다 이렇게해야해?
        /*
        IEncoder encoder = new Base64Encoder();
        String result = encoder.encode(url);

        IEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);*/
        // --> 점점감추기시작함

        // base64, urlencoder ,, 바꿀 때 비효율적
//        Encoder encoder = new Encoder();
//        String result = encoder.encode(url);

        // DI완성 , 외부에서 코드만 주입하면 된다.
        // but 객체는 아직 프로그래머가 관리한다 new를 이용해서..
//        Encoder encoder = new Encoder(new Base64Encoder());
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);





        System.out.println(result);
//        System.out.println(urlResult);
    }
}
