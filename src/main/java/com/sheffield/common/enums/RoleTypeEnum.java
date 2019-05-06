package com.sheffield.common.enums;

import com.sheffield.common.entity.po.UserPo;

public enum RoleTypeEnum {

    ADMIN(1),USER(0);

    private Integer role;

    RoleTypeEnum(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public static boolean isAdmin(UserPo userPo) {
        return userPo != null && ADMIN.role.equals(userPo.getRole());
    }
}
