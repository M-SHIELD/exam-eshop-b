package com.micah.goods_example.enums;

public enum ProductTypeEnum {
    PINK("pink", "拼团"),
    SECKILL("seckill", "秒杀"),
    COMBINATION("combination", "拼团产品");

    private final String value;
    private final String desc;

    ProductTypeEnum(final String value, final String desc) {
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
