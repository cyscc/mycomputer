package com.cyss.mycomputer.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.interceptor
 * @Author: cyss
 * @CreatTime: 2022-09-11 14:42
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("uid");
        if(obj == null){
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }
}
