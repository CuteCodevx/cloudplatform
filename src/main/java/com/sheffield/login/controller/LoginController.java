package com.sheffield.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sheffield.common.entity.po.UserPo;
import com.sheffield.common.result.ActionResult;
import com.sheffield.login.service.UserService;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping("userInfo")
    @ResponseBody
    public ActionResult<UserPo> userInfo (HttpSession session) {
        ActionResult.Builder<UserPo> builder = new ActionResult.Builder<>();
        Object userId = session.getAttribute("userId");
        UserPo userPo = userService.getUser(userId);
        userPo.setPassword("******");
        return builder.data(userPo).build();
    }

    @PostMapping("login")
    @ResponseBody
    public ActionResult<String> login(HttpSession session, HttpServletResponse response, @RequestParam String userName, @RequestParam String password) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        ActionResult<UserPo> login = userService.login(userName, password);

        if (!login.successful()) {
            return builder.code(login.getCode()).message(login.getMessage()).build();
        }
        session.setAttribute("userId", login.getData().getUserId());
        session.setAttribute("userName", login.getData().getUserName());
        session.setAttribute("role", login.getData().getRole());

        Cookie cookie = new Cookie("userName", login.getData().getUserName());
        cookie.setMaxAge(12*3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        return builder.build();
    }

    @GetMapping("loginOut")
    public ModelAndView loginOut(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Integer userId = (Integer) session.getAttribute("userId");

        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("role");

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("userName".equals(cookie.getName())) {
                Cookie cookie2 = new Cookie(cookie.getName(), "");
                cookie2.setPath("/");
                cookie2.setMaxAge(0);
                response.addCookie(cookie2);
            }
        }

        userService.loginOut(userId);

        return new ModelAndView("login");
    }

    @GetMapping("register")
    public ModelAndView toRegister(){
        return new ModelAndView("register");
    }

    @PostMapping("register")
    @ResponseBody
    public ActionResult<String> register(HttpSession session, HttpServletResponse response, @RequestParam String userName, @RequestParam String password) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        ActionResult<UserPo> register = userService.register(userName, password);

        if (!register.successful()) {
            return builder.code(register.getCode()).message(register.getMessage()).build();
        }
        session.setAttribute("userId", register.getData().getUserId());
        session.setAttribute("role", register.getData().getRole());
        session.setAttribute("userName", register.getData().getUserName());

        Cookie cookie = new Cookie("userName", register.getData().getUserName());
        cookie.setMaxAge(12*3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        return builder.build();
    }

    @RequestMapping(value = "/index")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }
}

