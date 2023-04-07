package com.micah.goods_example.entity.dao;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Collection {

    private Integer id;

    @ApiModelProperty("商品id")
    private Integer goodsId;

    @ApiModelProperty("买家id")
    @TableField("maijia_id")
    private Integer maiJiaId;

    @ApiModelProperty("收藏时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date collectionTime;

    @ApiModelProperty("商品名字")
    private String goodsName;

    @TableField(select = false)
    private Double price;

    private String goodsImg;

}
