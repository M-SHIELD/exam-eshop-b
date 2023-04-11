package com.micah.eshop.entity.vo;

import com.micah.eshop.entity.OrderItemEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderInfoDto
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/11 15:38
 * @Version 1.0
 **/
@Getter
@Setter
public class OrderDto {

    private Long id;
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    @ApiModelProperty(value = "用户id")
    private int uid;
    /**
     * 订单总金额
     */
    @ApiModelProperty(value = "订单总金额")
    private BigDecimal totalAmount;
    /**
     * 实际支付金额
     */
    @ApiModelProperty(value = "实际支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty("支付状态")
    private int payType;
    @ApiModelProperty(value = "订单状态，0：待支付，1：已支付，2:待发货 3：已发货，4：已收货，5：已完成，6：已取消，7：已退款，8：已删除")
    private int status;
    private Date createTime;
    private Date updateTime;
    private int isDel;
    @ApiModelProperty(value = "订单列表")
    private List<OrderItemEntity> products;
}
