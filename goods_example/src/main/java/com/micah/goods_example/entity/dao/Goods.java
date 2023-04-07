package com.micah.goods_example.entity.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author Micah
 * @since 2022-02-27 17:24:25
 */
@Accessors(chain = true)
@Data
@ApiModel("货物实体")
public class Goods implements Serializable {
    private static final long serialVersionUID = 592798752024617338L;

    @TableId
    @ApiModelProperty("货物id")
    private Integer pid;

    @ApiModelProperty("货物名称")
    private String pname;

    @ApiModelProperty("货物价格")
    private Double price;

    @ApiModelProperty("货物标记:新品1,不是0")
    private String flag;

    @ApiModelProperty("货物图片路径")
    private String picturepath;

    @ApiModelProperty("货物类别")
    private Integer categoryId;

    @ApiModelProperty("商品（产品）描述")
    private String descri;

    @ApiModelProperty("评论")
    private String remark;

    @ApiModelProperty("是否为积分商品,是为1,否为0")
    private Integer isfictitious;

    @ApiModelProperty("页码")
    @TableField(select = false)
    private Integer Page;

    @ApiModelProperty("排序方式")
    @TableField(select = false)
    private Integer orderBy;

    @ApiModelProperty("排序方式：升序为0，降序为1")
    @TableField(select = false)
    private Integer descOrAsc;

    @ApiModelProperty("从第几行开始")
    @TableField(select = false)
    private Long current;

    @ApiModelProperty("一页展示多少行")
    @TableField(select = false)
    private Long size;

    @TableField(select = false)
    private String goodsSku;
    @TableField(select = false)
    private Integer stock;
    @TableField(select = false)
    private Double sPrice;
    @TableField(select = false)
    private Integer state;
    @TableField(select = false)
    private Integer cid;
    @TableField(select = false)
    private String skuValues;
    @TableField(select = false)
    private String skuValue;
}
