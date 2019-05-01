package com.sheffield.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sheffield.common.dao.BaseDao;
import com.sheffield.common.entity.po.UserPo;
import com.sheffield.common.result.ActionResult;
import com.sheffield.login.service.UserService;

/**
 *
 *
 * @author: wuyifan
 * @since: 2019年05月01日 19:07
 * @version 1.0
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public ActionResult<String> login(HttpSession session, @RequestParam String userName, @RequestParam String password) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        ActionResult<UserPo> login = userService.login(userName, password);

        if (!login.successful()) {
            return builder.code(login.getCode()).message(login.getMessage()).build();
        }
        session.setAttribute("userId", login.getData().getUserId());
        session.setAttribute("userName", login.getData().getUserName());
        return builder.build();
    }

    @GetMapping("toRegister")
    public ModelAndView toRegister(){
        return new ModelAndView("register");
    }

    @PostMapping("register")
    @ResponseBody
    public ActionResult<String> register(HttpSession session, @RequestParam String userName, @RequestParam String password) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        ActionResult<UserPo> register = userService.register(userName, password);

        if (!register.successful()) {
            return builder.code(register.getCode()).message(register.getMessage()).build();
        }
        session.setAttribute("userId", register.getData().getUserId());
        session.setAttribute("userName", register.getData().getUserName());
        return builder.build();
    }

    @RequestMapping(value = "/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }
}

