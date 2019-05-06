package com.sheffield.common.enums;

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
