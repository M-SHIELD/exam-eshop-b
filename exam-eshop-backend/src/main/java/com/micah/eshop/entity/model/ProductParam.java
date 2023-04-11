package com.micah.eshop.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

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

    @ApiModelProperty(value = "当前页数")
    private Integer currPage;


    @ApiModelProperty(value = "搜索关键词")
    private String keyWord;

}
