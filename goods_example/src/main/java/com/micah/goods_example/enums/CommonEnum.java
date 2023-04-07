package com.micah.goods_example.enums;

/**
 * 通用枚举
 */
public enum CommonEnum {
    DEL_STATUS_0(0, "未删除"),
    DEL_STATUS_1(1, "已删除"),
    SHOW_STATUS_0(0, "未显示"),
    SHOW_STATUS_1(1, "显示");

    private final Integer value;
    private final String desc;

    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    CommonEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }
}
