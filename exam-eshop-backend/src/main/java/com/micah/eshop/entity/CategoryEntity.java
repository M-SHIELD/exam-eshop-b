package com.micah.eshop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品分类表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Category商品分类表实体")
@Accessors(chain = true)
@TableName("e_category")
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty(value = "")
    private Integer id;
    /**
     * 分类名
     */
    @ApiModelProperty(value = "分类名")
    private String cname;
    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private Integer level;
    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer parentId;
    /**
     * 图片地址（头图或分类图片）
     */
    @ApiModelProperty(value = "图片地址（头图或分类图片）")
    private String imgUrl;
    /**
     * 是否展示1是0否
     */
    @ApiModelProperty(value = "是否展示1是0否")
    private Integer isShow;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDel;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;


    //子类型
    @TableField(exist = false)
    private List<CategoryEntity> children;

}
