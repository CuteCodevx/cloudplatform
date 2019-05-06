package com.sheffield.common.enums;

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
