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
 * 用户表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.User用户表实体")
@Accessors(chain = true)
@TableName("e_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	@ApiModelProperty(value = "用户ID")
private Integer id;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
private String username;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
private String password;
	/**
	 * 头像
	 */
	@ApiModelProperty(value = "头像")
private String avator;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
private String email;
	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
private String phone;
	/**
	 * 是否删除，0-未删除，1-已删除
	 */
	@ApiModelProperty(value = "是否删除，0-未删除，1-已删除")
private Integer isDel;
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

}
