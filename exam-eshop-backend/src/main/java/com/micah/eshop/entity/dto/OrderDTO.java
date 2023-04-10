package com.micah.eshop.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private Integer 订单ID;

    @ApiModelProperty("买家id")
    private Integer maijiaid;

    @ApiModelProperty("商品状态：默认为空，0未支付，1待发货，2待收货，3待评价")
    private Integer state;

    @ApiModelProperty("交易是否已完成,默认为0，1已完成")
    private Integer isEnd;

    @ApiModelProperty("sku价格")
    private Double price;

    @ApiModelProperty("商品名字")
    private String pname;

    @ApiModelProperty("订单时间")
    private Date 时间;

    @ApiModelProperty("买家名")
    private String maiJiaName;

    @ApiModelProperty("订单地址")
    private String 地址;

    @ApiModelProperty("订单数量")
    private Integer number;




    @ApiModelProperty("从第几行开始")
    private Integer current;

    @ApiModelProperty("每页展示多少行")
    private Integer size;
}
