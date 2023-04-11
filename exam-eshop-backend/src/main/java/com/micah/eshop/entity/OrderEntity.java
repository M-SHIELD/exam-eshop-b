package com.micah.eshop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Order订单表实体")
@Accessors(chain = true)
@TableName("e_order")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @ApiModelProperty(value = "自增主键")
    private Long id;
    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Integer uid;
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
    /**
     * 支付方式，1：支付宝，2：微信
     */
    @ApiModelProperty(value = "支付方式，1：支付宝，2：微信")
    private Integer payType;
    /**
     * 订单状态，0：待支付，1：已支付，2:待发货 3：已发货，4：已收货，5：已完成，6：已取消，7：已退款，8：已删除
     */
    @ApiModelProperty(value = "订单状态，0：待支付，1：已支付，2:待发货 3：已发货，4：已收货，5：已完成，6：已取消，7：已退款，8：已删除")
    private Integer status;
    /**
     * 订单创建时间
     */
    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;
    /**
     * 订单更新时间
     */
    @ApiModelProperty(value = "订单更新时间")
    private Date updateTime;
    /**
     * 是否删除，0：否，1：是
     */
    @ApiModelProperty(value = "是否删除，0：否，1：是")
    private Integer isDel;

}
