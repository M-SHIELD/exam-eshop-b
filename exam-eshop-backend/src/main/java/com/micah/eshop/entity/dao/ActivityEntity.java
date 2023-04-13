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
 * 活动信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Activity活动信息表实体" )
@Accessors(chain = true)
@TableName("e_activity" )
public class ActivityEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @ApiModelProperty(value = "自增主键" )
    private Long id;
    /**
     * 活动名称
     */
    @ApiModelProperty(value = "活动名称" )
    private String activityName;
    /**
     * 活动描述
     */
    @ApiModelProperty(value = "活动描述" )
    private String activityDesc;
    /**
     * 活动类型，0-普通活动，1-秒杀活动，2-团购活动
     */
    @ApiModelProperty(value = "活动类型，0-普通活动，1-秒杀活动，2-团购活动" )
    private Integer activityType;
    /**
     * 活动开始时间
     */
    @ApiModelProperty(value = "活动开始时间" )
    private Date startTime;
    /**
     * 活动结束时间
     */
    @ApiModelProperty(value = "活动结束时间" )
    private Date endTime;
    /**
     * 活动状态，0-未开始，1-进行中，2-已结束
     */
    @ApiModelProperty(value = "活动状态，0-未开始，1-进行中，2-已结束" )
    private Integer status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间" )
    private Date updateTime;
    /**
     * 是否删除，0-否，1-是
     */
    @ApiModelProperty(value = "是否删除，0-否，1-是" )
    private Integer isDel;

}
