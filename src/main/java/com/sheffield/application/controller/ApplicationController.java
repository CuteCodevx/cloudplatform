package com.sheffield.application.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sheffield.application.service.ApplicationService;
import com.sheffield.bank.service.BankService;
import com.sheffield.common.entity.po.ApplicationPo;
import com.sheffield.common.entity.po.ExchangeRecordPo;
import com.sheffield.common.result.ActionResult;

@Controller
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @Resource
    private BankService bankService;

    @GetMapping("appList")
    @ResponseBody
    public ActionResult<PageInfo<ApplicationPo>> appList(Integer pageSize, Integer pageNum) {
        ActionResult.Builder<PageInfo<ApplicationPo>> builder = new ActionResult.Builder<>();
        PageInfo<ApplicationPo> pageInfo = applicationService.getApplicationList(pageSize, pageNum);

        return builder.data(pageInfo).build();
    }

    @GetMapping("exchangeRecords")
    @ResponseBody
    public ActionResult<PageInfo<ExchangeRecordPo>> exchangeRecords(HttpSession session, Integer pageSize, Integer pageNum) {
        ActionResult.Builder<PageInfo<ExchangeRecordPo>> builder = new ActionResult.Builder<>();
        Integer userId = (Integer) session.getAttribute("userId");
        PageInfo<ExchangeRecordPo> pageInfo = bankService.exchangeRecords(pageSize, pageNum, userId);
        return builder.data(pageInfo).build();
    }

    @GetMapping("useApp")
    @ResponseBody
    public ActionResult<String> useApp(HttpSession session, Integer appId) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        Integer userId = (Integer) session.getAttribute("userId");
        bankService.useApp(userId, appId);
        return builder.data("").build();
    }

    @GetMapping("deleteApplication")
    @ResponseBody
    public ActionResult<String> deleteApplication(HttpSession session, Integer appId) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        Integer userId = (Integer) session.getAttribute("userId");
        applicationService.deleteApplication(userId, appId);
        return builder.data("").build();
    }

    @GetMapping("passApplication")
    @ResponseBody
    public ActionResult<String> passApplication(HttpSession session, Integer appId) {
        ActionResult.Builder<String> builder = new ActionResult.Builder<>();
        Integer userId = (Integer) session.getAttribute("userId");
        applicationService.passApplication(userId, appId);
        return builder.data("").build();
    }
}
