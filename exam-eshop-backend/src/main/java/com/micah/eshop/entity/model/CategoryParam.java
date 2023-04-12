package com.micah.eshop.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName CategoryParam
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/10 16:25
 * @Version 1.0
 **/
@ApiModel(
        value = "CategoryParam (商品分类查询参数)",
        description = "商品分类查询参数"
)
@Getter
@Setter
public class CategoryParam {


    @ApiModelProperty(value = "分类等级 -1查全部 其他查对应等级 ")
    private Integer level;

    @ApiModelProperty(value = "关键字")
    private String keyword;


}
