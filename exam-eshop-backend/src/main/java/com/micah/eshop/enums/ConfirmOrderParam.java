package com.micah.eshop.enums;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ConfirmOrderParam {
    @NotBlank(message = "请提交购买的商品")
    @ApiModelProperty(value = "购物车ID")
    private List<Integer> cartId;
}
