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
 * 店铺信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Shop店铺信息表实体")
@Accessors(chain = true)
@TableName("e_shop")
public class ShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	@ApiModelProperty(value = "自增主键")
private Long id;
	/**
	 * 店铺名称
	 */
	@ApiModelProperty(value = "店铺名称")
private String shopName;
	/**
	 * 店铺描述
	 */
	@ApiModelProperty(value = "店铺描述")
private String shopDesc;
	/**
	 * 店铺LOGO URL
	 */
	@ApiModelProperty(value = "店铺LOGO URL")
private String logoUrl;
	/**
	 * 店铺横幅 URL
	 */
	@ApiModelProperty(value = "店铺横幅 URL")
private String bannerUrl;
	/**
	 * 省份
	 */
	@ApiModelProperty(value = "省份")
private String province;
	/**
	 * 城市
	 */
	@ApiModelProperty(value = "城市")
private String city;
	/**
	 * 区域
	 */
	@ApiModelProperty(value = "区域")
private String district;
	/**
	 * 详细地址
	 */
	@ApiModelProperty(value = "详细地址")
private String detail;
	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度")
private BigDecimal longitude;
	/**
	 * 纬度
	 */
	@ApiModelProperty(value = "纬度")
private BigDecimal latitude;
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
	 * 是否删除，0-否，1-是
	 */
	@ApiModelProperty(value = "是否删除，0-否，1-是")
private Integer isDel;

}
