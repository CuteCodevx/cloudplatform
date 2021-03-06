package com.sheffield.bank.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sheffield.bank.service.BankService;
import com.sheffield.common.dao.BaseDao;
import com.sheffield.common.entity.po.ApplicationPo;
import com.sheffield.common.entity.po.ExchangeRecordPo;
import com.sheffield.common.entity.po.UserPo;
import com.sheffield.common.enums.ExchangeTypeEnum;
import com.sheffield.common.enums.IncomeTypeEnum;
import com.sheffield.common.enums.RoleTypeEnum;
import com.sheffield.login.service.UserService;

@Service
public class BankServiceImpl implements BankService {

    @Resource
    private BaseDao baseDao;

    @Resource
    private UserService userService;

    @Override
    public PageInfo<ExchangeRecordPo> exchangeRecords(Integer pageSize, Integer pageNum, Integer userId) {

        UserPo userPo = userService.getUser(userId);
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        ExchangeRecordPo param = new ExchangeRecordPo();
        if (!RoleTypeEnum.isAdmin(userPo)) {
            param.setUserId(userId);
        }
        param.setIsDeleted(0);

        return baseDao.selectPageListAndCount(ExchangeRecordPo.class,
                "selectList", param, pageNum, pageSize, "create_time desc");
    }

    @Override
    public void uploadApp(Integer userId, Integer appId, String applicationName) {
        UserPo userPo = userService.getUser(userId);

        ExchangeRecordPo po = new ExchangeRecordPo();

        po.setUserId(userId);
        po.setUserName(userPo.getUserName());
        po.setApplicationId(appId);
        po.setApplicationName(applicationName);
        po.setExhangeType(ExchangeTypeEnum.UPLOAD_APP.getType());
        po.setIsIncome(IncomeTypeEnum.OUT.getType());
        po.setPeanuts(5L);
        po.setCreateTime(new Date());

        baseDao.insert(po);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("count", 5L);
        // Deduct the amount of the user
        baseDao.update(UserPo.class, "deductCount", map);
    }

    @Override
    public void useApp(Integer userId, Integer appId) {
        ApplicationPo applicationPo = baseDao.selectById(ApplicationPo.class, appId);

        if (userId.equals(applicationPo.getUserId())) {
            return;
        }

        if (RoleTypeEnum.isAdmin(userService.getUser(userId))) {
            return;
        }

        // save transaction information
        ExchangeRecordPo po = new ExchangeRecordPo();
        UserPo userPo = userService.getUser(userId);
        po.setUserId(userId);
        po.setUserName(userPo.getUserName());
        po.setApplicationId(appId);
        po.setExhangeType(ExchangeTypeEnum.USE_APP.getType());
        po.setApplicationName(applicationPo.getApplicationName());
        po.setIsIncome(IncomeTypeEnum.OUT.getType());
        po.setPeanuts(3L);
        po.setCreateTime(new Date());

        baseDao.insert(po);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("count", 3L);
        // Deduct the amount of the user
        baseDao.update(UserPo.class, "deductCount", map);

        // Add the balance for application developer
        map.put("userId", applicationPo.getUserId());
        baseDao.update(UserPo.class, "addCount", map);

        // Add the transaction record for application developer
        ExchangeRecordPo po2 = new ExchangeRecordPo();

        po2.setUserId(applicationPo.getUserId());
        po2.setUserName(applicationPo.getUserName());
        po2.setApplicationId(appId);
        po2.setExhangeType(ExchangeTypeEnum.USE_APP.getType());
        po2.setApplicationName(applicationPo.getApplicationName());
        po2.setPeanuts(3L);
        po2.setIsIncome(IncomeTypeEnum.IN.getType());
        po2.setCreateTime(new Date());

        baseDao.insert(po2);
    }
}
