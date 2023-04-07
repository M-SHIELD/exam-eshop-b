package com.micah.goods_example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Wallet {

    @TableId
    private Integer wid;

    @ApiModelProperty("买家id")
    @TableField("MaiJiaID")
    private Integer maijiaid;

    @ApiModelProperty("总资产")
    private Double money;

    @ApiModelProperty("累计充值")
    @TableField("total_recharge")
    private Double totalRecharge;

    @ApiModelProperty("累计消费")
    @TableField("total_consumption")
    private Double totalConsumption;

}
