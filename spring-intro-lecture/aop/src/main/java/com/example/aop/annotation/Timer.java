package com.example.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// 커스텀 어노테이션에서 자주 쓰는 방식
@Target({ElementType.TYPE, ElementType.METHOD}) // 타겟을 타입과 메소드에 건다
@Retention(RetentionPolicy.RUNTIME) // 어느 시점까지 메모리를 가져갈 것인가
public @interface Timer {
}
