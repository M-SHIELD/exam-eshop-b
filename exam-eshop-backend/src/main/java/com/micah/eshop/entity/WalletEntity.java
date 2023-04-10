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
 * 用户钱包表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Wallet用户钱包表实体")
@Accessors(chain = true)
@TableName("e_wallet")
public class WalletEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	@ApiModelProperty(value = "自增主键")
private Long id;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
private Long uid;
	/**
	 * 余额
	 */
	@ApiModelProperty(value = "余额")
private BigDecimal balance;
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
	 * 是否删除，0：否，1：是
	 */
	@ApiModelProperty(value = "是否删除，0：否，1：是")
private Integer isDel;

}
