package com.micah.eshop.enums;

public enum CartTypeEnum {
    NEW_0(0, "加入购物车"),

    NEW_1(1, "加入购物车直接购买");

    private final Integer value;
    private final String desc;

    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    CartTypeEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }
}
