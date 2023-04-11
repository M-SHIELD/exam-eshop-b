package com.micah.eshop.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName OrderParam
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/11 15:32
 * @Version 1.0
 **/
@ApiModel(
        value = "OrderParam (订单查询参数)",
        description = "订单查询参数"
)
@Getter
@Setter
public class OrderParam {
    @NotBlank(message = "订单状态不能为空")
    @ApiModelProperty(value = " 订单状态，-1 全部 0：待支付，1：已支付，2:待发货 3：已发货，4：已收货，5：已完成，6：已取消，7：已退款，8：已删除")
    private Integer status;

    /**
     * 用户id
     */
    @ApiModelProperty(value = " 用户id 不用传")
    private Long uid;



}
