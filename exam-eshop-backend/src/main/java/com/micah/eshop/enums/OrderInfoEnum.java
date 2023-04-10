package com.micah.eshop.enums;

import java.util.stream.Stream;

/**
 * 顶大枚举常量
 */
public enum OrderInfoEnum {

    STATUS_0(0, "默认"),
    STATUS_1(1, "待收货"),
    STATUS_2(2, "已收货"),
    STATUS_3(3, "已完成"),
    PAY_STATUS_0(0, "未支付"),
    PAY_STATUS_1(1, "已支付"),
    REFUND_STATUS_0(0, "正常"),
    REFUND_STATUS_1(1, "退款中"),
    REFUND_STATUS_2(2, "已退款"),
    BARGAIN_STATUS_1(1, "参与中"),
    BARGAIN_STATUS_2(2, "参与失败"),
    BARGAIN_STATUS_3(3, "参与成功"),
    PINK_STATUS_1(1, "进行中"),
    PINK_STATUS_2(2, "已完成"),
    PINK_STATUS_3(3, "未完成"),
    PINK_REFUND_STATUS_0(0, "拼团正常"),
    PINK_REFUND_STATUS_1(1, "拼团已退款"),
    CANCEL_STATUS_0(0, "正常"),
    CANCEL_STATUS_1(1, "已取消"),
    CONFIRM_STATUS_0(0, "正常"),
    CONFIRM_STATUS_1(1, "确认"),
    PAY_CHANNEL_0(0, "公众号/H5支付渠道"),
    PAY_CHANNEL_1(1, "小程序支付渠道"),
    SHIPPIING_TYPE_1(1, "快递"),
    SHIPPIING_TYPE_2(2, "门店自提");

    private final Integer value;
    private final String desc;

    //对比枚举
    public static OrderInfoEnum toType(int value) {
        OrderInfoEnum orderInfoEnum = Stream.of(values()).filter((p) -> {
            return p.value == value;
        }).findAny().orElse(null);
        return orderInfoEnum;
    }


    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    OrderInfoEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }
}
