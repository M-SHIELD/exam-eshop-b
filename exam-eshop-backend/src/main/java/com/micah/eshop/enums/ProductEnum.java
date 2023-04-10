package com.micah.eshop.enums;

import java.util.stream.Stream;

/**
 * 首页商品分类枚举
 */
public enum ProductEnum {
    TYPE_1(1, "精品推荐"),
    TYPE_2(2, "热门榜单"),
    TYPE_3(3, "首发新品"),
    TYPE_4(4, "猜你喜欢");

    private final Integer value;
    private final String desc;

    // TODO toType 方法传入一个不在枚举的的 value 会报空指针异常请处理 orElse默认值的问题

    //Stream.of创建有限元流。
    //调用findAny方法时，可以自由选择流中的任何元素
    //如果找不到就会返回orElse中你自己设置的默认值
    public static ProductEnum toType(int value) {
        return Stream.of(values()).filter((p) -> {
            return p.value == value;
        }).findAny().orElse(null);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    ProductEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }
}
