package com.sheffield.application.service;

import com.github.pagehelper.PageInfo;
import com.sheffield.common.entity.po.ApplicationPo;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月02日 17:57
 * @version 1.0
 */ 
public interface ApplicationService {

    void saveApplication(String imageUrl,
                         String fileUrl,
                         String linkUrl,
                         String applicationName,
                         String desc,
                         Integer userId);


    PageInfo<ApplicationPo> getApplicationList(Integer pageSize, Integer pageNum);

    void deleteApplication(Integer userId, Integer appId);

    void passApplication(Integer userId, Integer appId);

}
