package com.sheffield.login.service.impl;

import javax.annotation.Resource;

import com.sheffield.common.dao.BaseDao;
import com.sheffield.common.entity.po.ApplicationPo;
import com.sheffield.login.service.ApplicationService;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月02日 2:17
 * @version 1.0
 */ 
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    private BaseDao baseDao;

    @Override
    public void saveApplication(String imageUrl, String fileUrl, String linkUrl, String applicationName, String desc, Integer userId) {
        ApplicationPo applicationPo = new ApplicationPo();
        applicationPo.setApplicationName(applicationName);
        applicationPo.setUserId(userId);
        applicationPo.setFileUrl(fileUrl);
        applicationPo.setImageUrl(imageUrl);
        applicationPo.setLinkUrl(linkUrl);
        applicationPo.setDesc(desc);
        baseDao.insert(applicationPo);
    }
}
