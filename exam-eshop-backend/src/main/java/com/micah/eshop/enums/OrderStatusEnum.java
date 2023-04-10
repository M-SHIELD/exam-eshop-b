package com.micah.eshop.enums;

import java.util.stream.Stream;

/**
 * 订单类型枚举
 */
public enum OrderStatusEnum {
    STATUS_0(0, "未支付"),
    STATUS_1(1, "待发货"),
    STATUS_2(2, "待收货"),
    STATUS_3(3, "待评价"),
    STATUS_4(4, "已完成"),
    STATUS_MINUS_1(-1, "退款中"),
    STATUS_MINUS_2(-2, "已退款"),
    STATUS_MINUS_3(-3, "退款");

    private final Integer value;
    private final String desc;

    OrderStatusEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static OrderStatusEnum toType(int value) {
        return Stream.of(values())
                .filter(Enum -> Enum.value == value)
                .findAny()
                .orElse(null);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
