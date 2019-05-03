package com.sheffield.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月03日 21:42
 * @version 1.0
 */
@Controller
public class BankController {

    @GetMapping("toBank")
    public ModelAndView toBank() {
        return new ModelAndView("bank");
    }

}
