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
   // @ResponseBody
    public ModelAndView login(HttpSession session, @RequestParam String userName, @RequestParam String password) {
        ModelAndView mv = new ModelAndView();
        ActionResult<UserPo> login = userService.login(userName, password);

        if (!login.successful()) {
            mv.setViewName("403");
            return mv;
        }
        session.setAttribute("userId", login.getData().getUserId());
        mv.setViewName("index");
        return mv;
    }
    @GetMapping("register")
    public ModelAndView toRegister(){
        return new ModelAndView("register");
    }
    @PostMapping("register")
    //@ResponseBody
    public ModelAndView register(HttpSession session, @RequestParam String userName, @RequestParam String password) {
        ModelAndView mv = new ModelAndView();
        ActionResult<UserPo> login = userService.register(userName, password);
        session.setAttribute("userId", login.getData().getUserId());
        if (!login.successful()) {
            mv.setViewName("register");
            return mv;
        }

        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }
}

