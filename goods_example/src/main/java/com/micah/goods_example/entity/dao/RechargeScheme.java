package com.micah.goods_example.entity.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RechargeScheme {

    @TableId
    @ApiModelProperty("充值方案")
    private Integer rid;

    @TableField("recharge_quantity")
    @ApiModelProperty("充值金额")
    private Integer rechargeQuantity;

    @ApiModelProperty("赠送")
    @TableField("give")
    private Integer give;
}
