package com.micah.eshop.entity.dao;

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
 * 订单详情表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.OrderItem订单详情表实体")
@Accessors(chain = true)
@TableName("e_order_item")
public class OrderItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @ApiModelProperty(value = "自增主键")
    private Long id;
    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private Long orderId;
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private Long productId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String productName;
    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片")
    private String productImage;
    /**
     * 商品单价
     */
    @ApiModelProperty(value = "商品单价")
    private BigDecimal productPrice;
    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    private Integer quantity;
    /**
     * 小计金额
     */
    @ApiModelProperty(value = "小计金额")
    private BigDecimal subtotalAmount;
    /**
     * 订单详情创建时间
     */
    @ApiModelProperty(value = "订单详情创建时间")
    private Date createTime;
    /**
     * 订单详情更新时间
     */
    @ApiModelProperty(value = "订单详情更新时间")
    private Date updateTime;
    /**
     * 是否删除，0：否，1：是
     */
    @ApiModelProperty(value = "是否删除，0：否，1：是")
    private Integer isDel;

}
