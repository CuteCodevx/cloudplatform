package com.sheffield.bank.service;

import com.github.pagehelper.PageInfo;
import com.sheffield.common.entity.po.ExchangeRecordPo;

/**
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月03日 20:36
 * @version 1.0
 */ 
public interface BankService {

    PageInfo<ExchangeRecordPo> exchangeRecords(Integer pageSize, Integer pageNum, Integer userId);

}
