package com.micah.eshop.enums;

/**
 * 充值类型枚举
 */
public enum BillDetailEnum {
    TYPE_1("recharge", "充值"),
    TYPE_2("brokerage", "返佣"),
    TYPE_3("pay_product", "消费"),
    TYPE_4("extract", "提现"),
    TYPE_5("pay_product_refund", "退款"),
    TYPE_6("system_add", "系统添加"),
    TYPE_7("system_sub", "系统减少"),
    TYPE_8("deduction", "减去"),
    TYPE_9("gain", "奖励"),
    TYPE_10("sign", "签到"),
    CATEGORY_1("now_money", "金额"),
    CATEGORY_2("integral", "积分");

    private final String value;
    private final String desc;

    BillDetailEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
