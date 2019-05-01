package com.sheffield.login.service;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月02日 2:16
 * @version 1.0
 */ 
public interface ApplicationService {

    void saveApplication(String imageUrl,
                         String fileUrl,
                         String linkUrl,
                         String applicationName,
                         String desc,
                         Integer userId);

}
