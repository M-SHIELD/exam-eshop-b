package com.micah.eshop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 积分表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Point积分表实体")
@Accessors(chain = true)
@TableName("e_point")
public class PointEntity implements Serializable {
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
	 * 积分总数
	 */
	@ApiModelProperty(value = "积分总数")
private Integer totalPoint;
	/**
	 * 可用积分
	 */
	@ApiModelProperty(value = "可用积分")
private Integer availablePoint;
	/**
	 * 冻结积分
	 */
	@ApiModelProperty(value = "冻结积分")
private Integer frozenPoint;
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
	 * 是否删除，0表示未删除，1表示已删除
	 */
	@ApiModelProperty(value = "是否删除，0表示未删除，1表示已删除")
private Integer isDel;

}
