package com.micah.eshop.entity.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 购物车表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.ShoppingCart购物车表实体")
@Accessors(chain = true)
@TableName("e_shopping_cart")
public class ShoppingCartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 购物车ID
	 */
	@TableId
	@ApiModelProperty(value = "购物车ID")
private Integer id;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
private Integer uid;
	/**
	 * 商品ID
	 */
	@ApiModelProperty(value = "商品ID")
private Integer productId;
	/**
	 * SKU ID
	 */
	@ApiModelProperty(value = "SKU ID")
private Integer skuId;
	/**
	 * 商品数量
	 */
	@ApiModelProperty(value = "商品数量")
private Integer quantity;
	/**
	 * 是否选中，1为选中，0为未选中
	 */
	@ApiModelProperty(value = "是否选中，1为选中，0为未选中")
private Integer selected;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
private Date updateTime;
	/**
	 * 是否删除，0为未删除，1为已删除
	 */
	@ApiModelProperty(value = "是否删除，0为未删除，1为已删除")
private Integer isDel;

}
