package com.micah.eshop.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * @ClassName ProductParam
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/11 15:32
 * @Version 1.0
 **/
@ApiModel(
        value = "ProductParam (商品列表查询参数)",
        description = "商品列表查询参数"
)
@Getter
@Setter
public class ProductParam {

    @ApiModelProperty(value = "0 综合 1 价格 2 新品")
    private Integer order;

    @ApiModelProperty(value = "asc正排序 desc倒排序")
    private String orderType;

    @ApiModelProperty(value = "当前页数 1开始")
    private Integer currPage;


    @ApiModelProperty(value = "搜索关键词")
    private String keyWord;

    @ApiModelProperty(value = "是否为积分商品，0表示不是，1表示是")
    private Integer isIntegral;

    @ApiModelProperty(value = "商品状态，0：下架，1：在售")
    private Integer status;

    @ApiModelProperty(value = "是否热门，0：否，1：是")
    private Integer isHot;

}
