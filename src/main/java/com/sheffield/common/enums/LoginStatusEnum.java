package com.sheffield.common.enums;

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
