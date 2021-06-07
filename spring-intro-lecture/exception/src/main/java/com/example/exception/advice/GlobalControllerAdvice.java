package com.example.exception.advice;
// 에러메세지가 굉장히 불친절하다고 생각될 때 직접 에러메세지를 설정해줄 수 있다.

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    // 내가 어떠한 값을 잡을거다 라고 익셉션 핸들러를 설정해준다
    @ExceptionHandler(value = Exception.class) // 전체적인 예외를 잡을거다
    public ResponseEntity exception(Exception e) {
        System.out.println("=====================");
        System.out.println(e.getLocalizedMessage());
        System.out.println("=====================");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(""); // 서버에서 일어나는 에러이다. 바디에는 아무것도담지않는다.

    }

    // 예외를 다 잡을 수 있다. --> 콘솔창에 뜨지 않는다.(자바프로그램이 뻗지않고 내가 예외를 잡는것)
    @ExceptionHandler(value = MethodArgumentNotValidException.class) // valid exception을 핸들링 할거다.
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    }
}
