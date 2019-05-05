package com.sheffield.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sheffield.common.entity.po.UserPo;
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

        if (userId != null) {
            boolean isLogin = userService.isOnline((Integer) userId);

            if(isLogin){
                return true;
            }else{
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
                return false;
            }
        } else {
            Cookie[] cookies = httpServletRequest.getCookies();
            for (Cookie cookie : cookies) {
                if ("userName".equals(cookie.getName())) {
                    UserPo userPo = userService.getUser(cookie.getName());
                    userService.login(userPo.getUserName(), userPo.getPassword());
                    httpServletRequest.setAttribute("userId", userPo.getUserId());
                    httpServletRequest.setAttribute("userName", userPo.getUserName());
                    httpServletRequest.setAttribute("role", userPo.getRole());
                    return true;
                }
            }
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            return false;
        }


    }

}
