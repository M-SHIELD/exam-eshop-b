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
 * 商品信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Product商品信息表实体" )
@Accessors(chain = true)
@TableName("e_product" )
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @ApiModelProperty(value = "自增主键" )
    private Long id;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称" )
    private String name;
    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述" )
    private String description;
    /**
     * 商品分类ID
     */
    @ApiModelProperty(value = "商品分类ID" )
    private Long categoryId;
    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格" )
    private BigDecimal price;
    /**
     * 商品库存
     */
    @ApiModelProperty(value = "商品库存" )
    private Integer stock;
    /**
     * 商品销量
     */
    @ApiModelProperty(value = "商品销量" )
    private Integer sales;
    /**
     * 是否为积分商品，0表示不是，1表示是
     */
    @ApiModelProperty(value = "是否为积分商品，0表示不是，1表示是" )
    private Integer isIntegral;
    /**
     * 商品状态，0：下架，1：在售
     */
    @ApiModelProperty(value = "商品状态，0：下架，1：在售" )
    private Integer status;
    /**
     * 商品创建时间
     */
    @ApiModelProperty(value = "商品创建时间" )
    private Date createTime;
    /**
     * 商品更新时间
     */
    @ApiModelProperty(value = "商品更新时间" )
    private Date updateTime;
    /**
     * 是否删除，0：否，1：是
     */
    @ApiModelProperty(value = "是否删除，0：否，1：是" )
    private Integer isDel;

}
