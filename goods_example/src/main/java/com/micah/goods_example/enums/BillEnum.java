package com.micah.goods_example.enums;

import java.util.stream.Stream;

/**
 * 支付枚举
 */
public enum BillEnum {
    PM_0(0, "支出"),
    PM_1(1, "获得"),
    STATUS_0(0, "默认"),
    STATUS_1(1, "有效"),
    STATUS_2(2, "无效");

    private final Integer value;
    private final String desc;

    BillEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static BillEnum toType(int value) {
        return (BillEnum) Stream.of(values()).filter((p) -> {
            return p.value == value;
        }).findAny().orElse(null);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
