package com.sheffield;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sheffield.interceptor.LoginInterceptor;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月01日 19:38
 * @version 1.0
 */ 
@Configuration
public class WebConfig implements WebMvcConfigurer  {


    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/register");
    }
}
