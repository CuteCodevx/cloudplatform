package com.sheffield.common.enums;

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
