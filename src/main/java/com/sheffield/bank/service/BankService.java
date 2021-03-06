package com.sheffield.bank.service;

import com.github.pagehelper.PageInfo;
import com.sheffield.common.entity.po.ExchangeRecordPo;

public interface BankService {

    PageInfo<ExchangeRecordPo> exchangeRecords(Integer pageSize, Integer pageNum, Integer userId);

    void uploadApp(Integer userId, Integer appId, String applicationName);

    void useApp(Integer userId, Integer appId);

}
