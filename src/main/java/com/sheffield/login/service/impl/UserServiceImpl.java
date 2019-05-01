package com.sheffield.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sheffield.common.LoginStatusEnum;
import com.sheffield.common.dao.BaseDao;
import com.sheffield.common.entity.po.UserPo;
import com.sheffield.common.result.ActionResult;
import com.sheffield.common.result.ResultType;
import com.sheffield.login.service.UserService;

/**
 *
 *
 * @author: wuyifan
 * @since: 2019年05月01日 19:19
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private BaseDao baseDao;

    @Override
    public boolean isOnline(Integer userId) {
        UserPo userPo = baseDao.selectById(UserPo.class, userId);
        return userPo != null && LoginStatusEnum.ONLINE.getStatus().equals(userPo.getLoginStatus());
    }

    @Override
    public UserPo getUser(Object userId) {
        return baseDao.selectById(UserPo.class, userId);
    }

    @Override
    public ActionResult<UserPo> register(String userName, String password) {
        ActionResult.Builder<UserPo> builder = new ActionResult.Builder<>();
        UserPo userPo = new UserPo();
        userPo.setUserName(userName);
        UserPo po = baseDao.selectOne(userPo);
        if (po != null) {
            return builder.resultType(ResultType.FAILURE).message("user name already existed").data(po).build();
        }

        userPo.setPassword(password);
        userPo.setLoginStatus(LoginStatusEnum.ONLINE.getStatus());
        userPo.setUserCount(500L);

        baseDao.insert(userPo);

        return builder.data(userPo).build();
    }

    @Override
    public ActionResult<UserPo> login(String userName, String password) {
        ActionResult.Builder<UserPo> builder = new ActionResult.Builder<>();
        UserPo userPo = new UserPo();
        userPo.setUserName(userName);
        if ((userPo = baseDao.selectOne(userPo)) == null) {
            return builder.resultType(ResultType.FAILURE).message("user name is not existed!").build();
        }
        if (!userPo.getPassword().equals(password)) {
            return builder.resultType(ResultType.FAILURE).message("password is wrong!").build();
        }
        UserPo updateParam = new UserPo();
        updateParam.setUserId(userPo.getUserId());
        updateParam.setLoginStatus(LoginStatusEnum.ONLINE.getStatus());
        baseDao.update(updateParam);

        return builder.data(userPo).build();
    }
}
