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
 * 系统消息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.SystemMessage系统消息表实体")
@Accessors(chain = true)
@TableName("e_system_message")
public class SystemMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	@ApiModelProperty(value = "自增主键")
private Long id;
	/**
	 * 消息标题
	 */
	@ApiModelProperty(value = "消息标题")
private String title;
	/**
	 * 消息内容
	 */
	@ApiModelProperty(value = "消息内容")
private String content;
	/**
	 * 消息状态，0-未读，1-已读
	 */
	@ApiModelProperty(value = "消息状态，0-未读，1-已读")
private Integer status;
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
