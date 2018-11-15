package com.kaikeba.primary.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * company: www.kaikeba.com
 * Author: Rey
 */
@Configuration
public class MyApplicationContext {
    @Bean
    public ServletRegistrationBean<SomeServlet> servletBean() {
        return new ServletRegistrationBean<>(new SomeServlet(), "/some");
    }
}
