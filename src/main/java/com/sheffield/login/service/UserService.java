package com.sheffield.login.service;

import com.sheffield.common.entity.po.UserPo;
import com.sheffield.common.result.ActionResult;

/**
 *
 *
 * @author: wuyifan
 * @since: 2019年05月01日 19:19
 * @version 1.0
 */
public interface UserService {

    /**
     * 判断用户是否登陆
     *
     * @param userId userId
     * @return boolean
     * @author wuyifan
     * @date 2019年5月1日 19:22
     */
    boolean isOnline(Integer userId);

    UserPo getUserByName(String userName);

    /**
     * 获取用户信息
     *
     * @param userId userId
     * @return com.sheffield.common.entity.po.UserPo
     * @author wuyifan
     * @date 2019年5月1日 23:16
     */
    UserPo getUser(Object userId);

    /**
     * 注册用户
     *
     * @param userName userName
     * @param password password
     * @author wuyifan
     * @date 2019年5月1日 19:23
     */
    ActionResult<UserPo> register(String userName, String password);

    /**
     * 用户登陆
     *
     * @param userName userName
     * @param password password
     * @return boolean
     * @author wuyifan
     * @date 2019年5月1日 19:24
     */
    ActionResult<UserPo> login(String userName, String password);

    void loginOut(Integer userId);

}
