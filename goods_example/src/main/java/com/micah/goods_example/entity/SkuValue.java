package com.micah.goods_example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("sku_value")
public class SkuValue {

    private Integer id;
    private Integer skuKeyId;
    @ApiModelProperty("skuKey属性值下的属性值")
    private String skuValue;
}
