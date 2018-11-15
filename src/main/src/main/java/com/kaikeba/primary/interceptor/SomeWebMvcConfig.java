package com.kaikeba.primary.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * company: www.kaikeba.com
 * Author: Rey
 */
@Configuration   // 表示当前类为CodeConfig类，即充当Spring容器
public class SomeWebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        SomeIntercepter someIntercepter = new SomeIntercepter();
        registry.addInterceptor(someIntercepter)
                .addPathPatterns("/first/**")   // 拦截first开关的请求
                .excludePathPatterns("/first/aaa");  // 不拦截second开头的请求
    }
}
