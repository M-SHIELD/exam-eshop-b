package com.micah.eshop.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @ClassName CategoryParam
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/10 16:25
 * @Version 1.0
 **/
@ApiModel(
        value = "UserBehaviorParam (用户行为传入参数)",
        description = "用户行为传入参数"
)
@Getter
@Setter
@Accessors(chain = true)
public class UserBehaviorParam {

    @ApiModelProperty(value = "商品ID")
    private String productId;

    /**
     * 用户行为类型，1：收藏，2：点赞，3：足迹
     */
    @ApiModelProperty(value = "用户行为类型，1：收藏，2：点赞，3：足迹")
    private Integer behaviorType;


    @ApiModelProperty(value = "当前页数 1开始")
    private Integer currPage=1;





}
