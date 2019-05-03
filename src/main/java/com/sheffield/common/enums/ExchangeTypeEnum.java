package com.sheffield.common.enums;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月03日 20:53
 * @version 1.0
 */ 
public enum ExchangeTypeEnum {
    UPLOAD_APP(1),USE_APP(0);

    private Integer type;

    ExchangeTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
