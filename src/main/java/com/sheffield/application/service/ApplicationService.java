package com.sheffield.application.service;

import com.github.pagehelper.PageInfo;
import com.sheffield.common.entity.po.ApplicationPo;

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
