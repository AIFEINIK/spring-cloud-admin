package com.app.interfaces.enums;

import lombok.Data;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/4
 * @since 1.0.0
 */
public enum UserStatusEnum {

    NORMAL(0, "正常"),
    DELETED(-1, "已删除");

    private int index;
    private String name;

    UserStatusEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static UserStatusEnum getType(int index) {
        final UserStatusEnum[] values = UserStatusEnum.values();
        for (UserStatusEnum value : values) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
