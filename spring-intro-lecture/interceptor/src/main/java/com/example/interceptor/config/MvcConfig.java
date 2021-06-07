package com.example.interceptor.config;

import com.example.interceptor.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 인터셉터를 등록하기 위한 컨피그 클래스
@RequiredArgsConstructor // final이 붙은 애들을 생성자에서 주입시켜준다
public class MvcConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor; // 순환참조를 막기 위해 Autowired 보다 RequiredAr,,를 쓴다

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
