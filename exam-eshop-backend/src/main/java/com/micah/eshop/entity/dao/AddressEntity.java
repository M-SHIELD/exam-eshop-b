package com.micah.eshop.entity.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 收货地址表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Data
@ApiModel(value = "com.micah.eshop.entity.Address收货地址表实体")
@Accessors(chain = true)
@TableName("e_address")
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @ApiModelProperty(value = "自增主键")
    private Integer id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Integer uid;
    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    private String realName;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phone;
    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;
    /**
     * 区/县
     */
    @ApiModelProperty(value = "区/县")
    private String district;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String detail;
    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String postCode;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;
    /**
     * 是否默认地址，0：否，1：是
     */
    @ApiModelProperty(value = "是否默认地址，0：否，1：是")
    private Integer isDefault;
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
     * 是否删除，0：否，1：是
     */
    @ApiModelProperty(value = "是否删除，0：否，1：是")
    private Integer isDel;

}
