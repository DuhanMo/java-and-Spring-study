package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // aop로 동작을 하기위해서 작성.
@Component // 스프링에서 관리가 되어야 하기 때문에.
public class ParameterAop {

    // 메소드의 이름은 중요하지 않음, 룰을 설정함
    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // 수식이 엄청많음. 컨트롤러 하위의 모든 메소드를 다 AOP로 보겠다
    private void cut() {}
    // 메소드 실행되기 전 아규먼트 확인, 메소드 이름 중요치않음
    @Before("cut()") // 포인트컷 메소드의 이름을 넣어줌
    public void before(JoinPoint joinPoint) {
        // 메소드 이름은 joinpoint에서 가져올 수 있음 ??
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // 형변환을 하면 Method를 가져올 수 있
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs(); // 메소드로 들어가고 있는 Object들을 가져옴


        for (Object obj: args
             ) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    // 실행 후 어떠한 값이 리턴되는가 확인 , 메소드 이름 중요치않음
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
