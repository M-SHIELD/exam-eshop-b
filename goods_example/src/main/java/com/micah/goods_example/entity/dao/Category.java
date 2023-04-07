package com.micah.goods_example.entity.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * (Category)实体类
 *
 * @author Micah
 * @since 2022-02-27 17:24:25
 */
@Accessors(chain = true)
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 583649933342383143L;

    @ApiModelProperty("商品分类id")
    private Integer cid;

    @ApiModelProperty("商品分类名")
    private String cname;

    @ApiModelProperty("分类等级")
    private Integer level;

    @ApiModelProperty("商品分类父id")
    @TableField("parent_Id")
    private Integer parentId;

    @ApiModelProperty("商品分类图片/头图路径")
    @TableField("img_url")
    private String imgurl;

    //下级分类集合
    @TableField(select = false)
    private List<Category> children;
}
