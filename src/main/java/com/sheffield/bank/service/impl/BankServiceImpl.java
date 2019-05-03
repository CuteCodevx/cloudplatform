package com.sheffield.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.sheffield.bank.service.BankService;
import com.sheffield.common.dao.BaseDao;
import com.sheffield.common.entity.po.ExchangeRecordPo;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月03日 20:36
 * @version 1.0
 */ 
@Service
public class BankServiceImpl implements BankService {
    @Resource
    private BaseDao baseDao;

    @Override
    public PageInfo<ExchangeRecordPo> exchangeRecords(Integer pageSize, Integer pageNum, Integer userId) {
        ExchangeRecordPo param = new ExchangeRecordPo();
        param.setUserId(userId);

        return baseDao.selectPageListAndCount(ExchangeRecordPo.class,
                "selectList", param, pageNum, pageSize, "create_time desc");
    }
}
