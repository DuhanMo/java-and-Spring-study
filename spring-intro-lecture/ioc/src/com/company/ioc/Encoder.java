package com.company.ioc;

import java.util.Base64;

public class Encoder {
    // ********* 의존하고 있는 iEncoder를 main클래스에서 쓸때 외부에서 주입받음 ---> DI
    private IEncoder iEncoder;

    /* // urlencoder 로 바꿔주세요 -> base64로 바꿔주세요 -> 본질을 건드리며 굉장히 비효율적임
        public Encoder(){
    //        this.iEncoder = new Base64Encoder();
            this.iEncoder = new UrlEncoder();
        }
    */
    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

//    public String encode(String message) {
//        return Base64.getEncoder().encodeToString(message.getBytes());
//    }
public String encode(String message) {
    return iEncoder.encode(message);
}
}
