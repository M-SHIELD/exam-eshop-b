package com.micah.eshop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统信息存储表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.SystemInfo系统信息存储表实体")
@Accessors(chain = true)
@TableName("e_system_info")
public class SystemInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @ApiModelProperty(value = "自增主键")
    private Long id;
    /**
     * 信息名称
     */
    @ApiModelProperty(value = "信息名称")
    private String name;
    /**
     * 信息值
     */
    @ApiModelProperty(value = "信息值")
    private String value;
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
     * 是否删除，0-否，1-是
     */
    @ApiModelProperty(value = "是否删除，0-否，1-是")
    private Integer isDel;

}
