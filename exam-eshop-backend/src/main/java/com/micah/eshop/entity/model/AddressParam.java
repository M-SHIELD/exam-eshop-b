package com.micah.eshop.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName CategoryParam
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/10 16:25
 * @Version 1.0
 **/
@ApiModel(
        value = "AddressParam (地址查询参数)",
        description = "地址查询参数"
)
@Getter
@Setter
public class AddressParam {
    /**
     * 自增主键
     */

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "当前页数")
    private Integer currPage = 1;


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

    @ApiModelProperty(value = "是否默认地址，0：否，1：是")
    private Integer isDefault;
}
