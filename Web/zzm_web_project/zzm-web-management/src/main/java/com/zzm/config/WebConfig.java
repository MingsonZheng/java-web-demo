package com.zzm.config;

import com.zzm.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mingson
 * @version 1.0
 */
@Configuration //配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**");
    }
}
