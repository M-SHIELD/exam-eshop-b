package com.micah.goods_example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WalletDTO {

    @ApiModelProperty("买家ID")
    private Integer maijiaid;

    @ApiModelProperty("充值方案")
    private Integer rid;
}
