package com.micah.goods_example.entity.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("sku")
public class Sku {

    @ApiModelProperty("skuId")
    private Integer id;
    @ApiModelProperty("商品id")
    private Integer gid;
    @ApiModelProperty("商品规格")
    private String goodsSku;
    @ApiModelProperty("库存")
    private Integer stock;
    @ApiModelProperty("价格")
    private Double price;
    @ApiModelProperty("状态")
    private Integer state;

    @TableField(select = false)
    private Integer cid;
    @TableField(select = false)
    private String skuValues;
    @TableField(select = false)
    private String skuValue;
}
