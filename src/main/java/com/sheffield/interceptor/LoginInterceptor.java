package com.sheffield.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sheffield.login.service.UserService;

/**
 * 
 *
 * @author:
 * @since:
 * @version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession(true);
        Object userId = session.getAttribute("userId");

        boolean isLogin = userService.isOnline((Integer) userId);

        if(isLogin){
            return true;
        }else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            return false;
        }
    }

}
