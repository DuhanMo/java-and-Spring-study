package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))") // 수식이 엄청많음. 컨트롤러 하위의 모든 메소드를 다 AOP로 보겠다
    private void cut() {}

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode() {

    }
    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for (Object arg:
             args) {
            if (arg instanceof User) { // 유저라는 클래스일때는 유저로 형변환 후
                User user = User.class.cast(arg);
                String base64Email = user.getEmail(); // 인코딩된 이메일을 꺼내온다
                System.out.println("before base64Email : " + base64Email);
                String email = new String(Base64.getDecoder().decode(base64Email),
                        "UTF-8");
                user.setEmail(email);
            }
        }
    }
    @AfterReturning(value = "cut()&&enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if (returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email);
        }
    }

}
