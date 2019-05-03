package com.sheffield.common.enums;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月03日 21:04
 * @version 1.0
 */ 
public enum  IncomeTypeEnum {

    IN(1), OUT(0);

    private Integer type;

    IncomeTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
