package com.app.interfaces.enums;

public enum ReturnStatusEnum {
    SUCCESS(200, "成功"),
    ILLEGAL_ARGUMENT(400, "服务端参数校验不合法"),
    PRODUCT_NOT_EXISTS(5001, "产品不存在"),
    UNKNOWN(5000, "未知异常");

    private final int value;
    private final String name;

    ReturnStatusEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
