package com.micah.eshop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 物流信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Logistics物流信息表实体")
@Accessors(chain = true)
@TableName("e_logistics")
public class LogisticsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @ApiModelProperty(value = "自增主键")
    private Long id;
    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private Long orderId;
    /**
     * 物流单号
     */
    @ApiModelProperty(value = "物流单号")
    private String logisticsNo;
    /**
     * 物流公司名称
     */
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompany;
    /**
     * 物流状态，0-待发货，1-已发货，2-已签收
     */
    @ApiModelProperty(value = "物流状态，0-待发货，1-已发货，2-已签收")
    private Integer status;
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
