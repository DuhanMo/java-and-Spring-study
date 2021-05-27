package com.example.springioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {
    // ********* 의존하고 있는 iEncoder를 main클래스에서 쓸때 외부에서 주입받음 ---> DI
    private IEncoder iEncoder;

    public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
public String encode(String message) {
    return iEncoder.encode(message);
}
}
