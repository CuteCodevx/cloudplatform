package com.sheffield.application.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sheffield.application.service.ApplicationService;
import com.sheffield.bank.service.BankService;
import com.sheffield.common.dao.BaseDao;
import com.sheffield.common.entity.po.ApplicationPo;
import com.sheffield.common.entity.po.UserPo;
import com.sheffield.common.enums.CheckStatusEnum;
import com.sheffield.common.enums.RoleTypeEnum;
import com.sheffield.login.service.UserService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    private BaseDao baseDao;

    @Resource
    private BankService bankService;

    @Resource
    private UserService userService;

    @Override
    public void saveApplication(String imageUrl, String fileUrl, String linkUrl, String applicationName, String desc, Integer userId) {
        UserPo userPo = userService.getUser(userId);

        ApplicationPo applicationPo = new ApplicationPo();
        applicationPo.setApplicationName(applicationName);
        applicationPo.setUserId(userId);
        applicationPo.setUserName(userPo.getUserName());
        applicationPo.setFileUrl(fileUrl);
        applicationPo.setImageUrl(imageUrl);
        applicationPo.setLinkUrl(linkUrl);
        applicationPo.setDescription(desc);
        baseDao.insert(applicationPo);

        bankService.uploadApp(userId, applicationPo.getApplicationId(), applicationName);
    }

    @Override
    public PageInfo<ApplicationPo> getApplicationList(Integer pageSize, Integer pageNum) {
        ApplicationPo applicationPo = new ApplicationPo();
        applicationPo.setIsDeleted(0);

        return baseDao.selectPageListAndCount(ApplicationPo.class, "selectList", applicationPo, pageNum, pageSize);
    }

    @Override
    public void deleteApplication(Integer userId, Integer appId) {
        if (!RoleTypeEnum.isAdmin(userService.getUser(userId))) {
            return;
        }

        ApplicationPo update = new ApplicationPo();
        update.setIsDeleted(1);
        update.setApplicationId(appId);

        baseDao.update(update);
    }

    @Override
    public void passApplication(Integer userId, Integer appId) {
        if (!RoleTypeEnum.isAdmin(userService.getUser(userId))) {
            return;
        }

        ApplicationPo update = new ApplicationPo();
        update.setCheckStatus(CheckStatusEnum.PASS.getStatus());
        update.setApplicationId(appId);

        baseDao.update(update);
    }

}
