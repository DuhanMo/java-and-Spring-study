package com.example.springioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component // Component 어노테이션 하나로 모든 관리를 스프링이 해준다. ApplicationContextProvider를 실행시키고,
            // applicationContext를 주입해줌
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override // applicationContext는 스프링이 주입해줌
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
