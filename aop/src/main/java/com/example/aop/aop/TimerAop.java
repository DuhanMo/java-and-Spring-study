package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 특정 메소드의 실행 시간을 알아볼 AOP
@Aspect
@Component // Bean은 클래스에 붙일 수 없음 메소드에만 쓸 수 있음
// Component 로 클래스 단위에 Bean을 등록할 수 있음
// Configuration 은 하나의 클래스에 여러개의 Bean이 등록된다는 어노테이션.
public class TimerAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // 수식이 엄청많음. 컨트롤러 하위의 모든 메소드를 다 AOP로 보겠다
    private void cut() {}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){}

    @Around("cut() && enableTimer()") // 두가지 조건을 같이 쓰겠다!
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 메소드가 실행되기 전
        Object result = joinPoint.proceed(); // 메소드가 반환하면 조인포인트의 프로시드를 호출하면 실질적인 메소드가 실행되고,
// 리턴된다면 result값에 들어가게 된다. 여기서 메소드가 실행

        // 메소드가 실행된 후
        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());

    }
}
