package com.sheffield.common.enums;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月03日 23:19
 * @version 1.0
 */ 
public enum  CheckStatusEnum {

    PASS(1),NO_PASS(0);

    private Integer status;

    CheckStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

}
