package com.example.filter.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
//@Component
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter { //javax.servlet 의 Filter
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request); // 필터단에서는 넘어온 request와 response를 형변환 시켜줄 수 있음
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response); //캐시컨텐츠를 하면 캐싱이 되어있기 때문에
        // 후에 누가 데이터를 읽으려고할 때 다시 읽게 해줌. 이걸안해주면 필터에서 br.readline을 해버리면 다른쪽에서 읽지못해 에러가 발생한다.

        chain.doFilter(httpServletRequest, httpServletResponse);

        String url = httpServletRequest.getRequestURI();


        // 후처리
        // req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {} , request body : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        log.info("response status : {}, responseBody: {}", httpStatus, resContent );
    }
}
