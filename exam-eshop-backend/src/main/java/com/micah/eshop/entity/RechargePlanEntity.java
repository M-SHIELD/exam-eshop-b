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
 * 充值方案表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.RechargePlan充值方案表实体")
@Accessors(chain = true)
@TableName("e_recharge_plan")
public class RechargePlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	@ApiModelProperty(value = "自增主键")
private Long id;
	/**
	 * 充值方案名称
	 */
	@ApiModelProperty(value = "充值方案名称")
private String name;
	/**
	 * 充值金额
	 */
	@ApiModelProperty(value = "充值金额")
private BigDecimal amount;
	/**
	 * 赠送金额
	 */
	@ApiModelProperty(value = "赠送金额")
private BigDecimal giveAmount;
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
