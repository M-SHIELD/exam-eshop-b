package com.micah.eshop.enums;

import java.util.stream.Stream;

/**
 * 支付类型枚举
 */
public enum PayTypeEnum {
    ALI("alipay", "支付宝支付"),
    WEIXIN("weixin", "微信支付"),
    YUE("yue", "余额支付"),
    INTEGRAL("integral", "积分兑换");

    private final String value;
    private final String desc;

    PayTypeEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static PayTypeEnum toType(String value) {
        return (PayTypeEnum) Stream.of(values()).filter((p) -> {
            return p.value.equals(value);
        }).findAny().orElse(null);
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
