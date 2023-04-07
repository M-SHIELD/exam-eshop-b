package com.micah.goods_example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (商品订单)实体类
 *
 * @author Micah
 * @since 2022-02-27 17:24:25
 */
@Accessors(chain = true)
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -91268870650724915L;

    @ApiModelProperty("订单id")
    private Integer ddid;

    @ApiModelProperty("商品id")
    private Integer pid;

    @ApiModelProperty("下单时间")
    private Date 时间;

    @ApiModelProperty("买家id")
    private Integer maijiaid;

    @ApiModelProperty("数量")
    private Integer number;

    @ApiModelProperty("地址id")
    private Integer 地址id;

    @ApiModelProperty("商品状态：默认为空，0未支付，1待发货，2待收货，3待评价")
    private Integer state;

    @ApiModelProperty("交易是否已完成,默认为0，1已完成")
    private Integer isEnd;

}
