package com.sheffield.application.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sheffield.application.service.ApplicationService;
import com.sheffield.common.entity.po.ApplicationPo;
import com.sheffield.common.result.ActionResult;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月02日 17:57
 * @version 1.0
 */
@Controller
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @GetMapping("appList")
    @ResponseBody
    public ActionResult<PageInfo<ApplicationPo>> appList(Integer pageSize, Integer pageNum) {
        ActionResult.Builder<PageInfo<ApplicationPo>> builder = new ActionResult.Builder<>();
        PageInfo<ApplicationPo> pageInfo = applicationService.getApplicationList(pageSize, pageNum);

        return builder.data(pageInfo).build();
    }

}
