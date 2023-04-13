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
 * 评价表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Evaluation评价表实体")
@Accessors(chain = true)
@TableName("e_evaluation")
public class EvaluationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评价ID
	 */
	@TableId
	@ApiModelProperty(value = "评价ID")
private Integer id;
	/**
	 * 订单ID
	 */
	@ApiModelProperty(value = "订单ID")
private Integer orderId;
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
private Integer uid;
	/**
	 * 评分
	 */
	@ApiModelProperty(value = "评分")
private Integer score;
	/**
	 * 评价内容
	 */
	@ApiModelProperty(value = "评价内容")
private String content;
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
