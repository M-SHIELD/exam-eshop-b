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
 * 用户行为表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.UserBehavior用户行为表实体")
@Accessors(chain = true)
@TableName("e_user_behavior")
public class UserBehaviorEntity implements Serializable {
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
    private Long userId;
    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private Long productId;
    /**
     * 用户行为类型，1：收藏，2：点赞，3：足迹
     */
    @ApiModelProperty(value = "用户行为类型，1：收藏，2：点赞，3：足迹")
    private Integer behaviorType;
    /**
     * 行为创建时间
     */
    @ApiModelProperty(value = "行为创建时间")
    private Date createTime;
    /**
     * 行为更新时间
     */
    @ApiModelProperty(value = "行为更新时间")
    private Date updateTime;
    /**
     * 是否删除，0：否，1：是
     */
    @ApiModelProperty(value = "是否删除，0：否，1：是")
    private Integer isDel;

}
