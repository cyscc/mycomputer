package com.cyss.mycomputer.config;

import com.cyss.mycomputer.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.config
 * @Author: cyss
 * @CreatTime: 2022-09-11 14:56
 * @Description:
 */

@Configuration
public class LoginInterceptorConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new LoginInterceptor();
        ArrayList<String> list = new ArrayList<>();
        list.add("/bootstrap3/**");
        list.add("/css/**");
        list.add("/images/**");
        list.add("/js/**");
        list.add("/web/login.html");
        list.add("/web/register.html");
        list.add("/web/index.html");
        list.add("/web/product.html");
        list.add("/users/reg");
        list.add("/users/login");
        list.add("/districts/**");
        list.add("/products/**");
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(list);
    }
}
