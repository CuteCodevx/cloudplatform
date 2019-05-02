package com.sheffield.application.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sheffield.application.service.ApplicationService;
import com.sheffield.common.dao.BaseDao;
import com.sheffield.common.entity.po.ApplicationPo;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月02日 17:59
 * @version 1.0
 */ 
@Service
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
        applicationPo.setDescription(desc);
        baseDao.insert(applicationPo);
    }

    @Override
    public PageInfo<ApplicationPo> getApplicationList(Integer pageSize, Integer pageNum) {
        return baseDao.selectPageListAndCount(ApplicationPo.class, "selectList", null, pageNum, pageSize);
    }

}
