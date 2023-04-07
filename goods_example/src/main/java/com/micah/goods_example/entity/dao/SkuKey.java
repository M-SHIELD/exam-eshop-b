package com.micah.goods_example.entity.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("sku_key")
public class SkuKey {
    private Integer id;
    @ApiModelProperty("商品分类id")
    private Integer categoryId;
    @ApiModelProperty("sku属性值")
    @TableField("sku_v")
    private String skuValues;
}
