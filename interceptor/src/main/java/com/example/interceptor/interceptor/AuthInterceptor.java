package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        //
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();
        log.info("request url : {}", url);

        // 애초에 필터단위에서 캐시를 구현하지않았다면 손실되었음
        // 여기서 권한 검사를 할것이다
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {} " , hasAnnotation);

        // 나의 서버는 모두 public으로 동작을 하는데
        // 단! Auth 권한을 가진 요청에 대해서는 세션, 쿠키, 를 검사하고싶다
        if (hasAnnotation) {
            // 권한 체크
            String query = uri.getQuery();
            log.info("query: {}", query);
            if (query.equals("name=steve")) {
                return true;
            }
            throw new AuthException();
        }

        return true; // true가 되어야 컨트롤러로 넘어간다
    }

    private boolean checkAnnotation(Object handler, Class clazz) {

        // resource js, html, 리소스에 대한건 무조건 통과--> 권한 확인안할거다
        if (handler instanceof ResourceHttpRequestHandler) {
            return true; // 통과
        }
        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            // Auth annotation이 있을 때는 true
            return true;
        }
        return false;
    }
}