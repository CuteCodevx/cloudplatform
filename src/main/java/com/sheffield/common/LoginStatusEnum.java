package com.sheffield.common;

/** 
 * 
 *
 * @author: wuyifan
 * @since: 2019年05月01日 19:20
 * @version 1.0
 */ 
public enum LoginStatusEnum {

    ONLINE(1),OFFLINE(0);

    private Integer status;

    LoginStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
