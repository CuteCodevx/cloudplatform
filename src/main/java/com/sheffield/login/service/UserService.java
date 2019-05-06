package com.sheffield.login.service;

import com.sheffield.common.entity.po.UserPo;
import com.sheffield.common.result.ActionResult;

public interface UserService {

    /**
     * is log or not
     *
     */
    boolean isOnline(Integer userId);

    UserPo getUserByName(String userName);

    /**
     * get user information
     *
     */
    UserPo getUser(Object userId);

    /**
     * register
     *
     */
    ActionResult<UserPo> register(String userName, String password);

    /**
     * login
     */
    ActionResult<UserPo> login(String userName, String password);

    void loginOut(Integer userId);

}
