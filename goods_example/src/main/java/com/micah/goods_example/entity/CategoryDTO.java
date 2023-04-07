package com.micah.goods_example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryDTO {

    @ApiModelProperty("商品分类id")
    private Integer cid;

    @ApiModelProperty("商品分类父id")
    @TableField("parent_Id")
    private Integer parentId;

}
