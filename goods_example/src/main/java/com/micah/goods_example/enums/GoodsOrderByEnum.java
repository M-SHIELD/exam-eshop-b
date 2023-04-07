package com.micah.goods_example.enums;

public enum GoodsOrderByEnum {

    DEFAULT(0),    //默认
    NEW(1),        //新品
    PRICE(2);       //价格

    private final Integer value;

    private GoodsOrderByEnum(Integer value) {
        this.value = value;
    }

    public static GoodsOrderByEnum valueOf(Integer value){
        switch (value){
            case 0: return GoodsOrderByEnum.DEFAULT;
            case 1: return GoodsOrderByEnum.NEW;
            case 2: return GoodsOrderByEnum.PRICE;
            default:
                return null;
        }
    }

}
