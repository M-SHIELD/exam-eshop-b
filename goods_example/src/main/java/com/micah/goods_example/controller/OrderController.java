package com.micah.goods_example.controller;

import com.micah.goods_example.entity.Order;
import com.micah.goods_example.entity.OrderDTO;
import com.micah.goods_example.service.OrderService;
import com.micah.goods_example.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "商品订单相关接口")
@RequestMapping("/商品订单")
public class OrderController {

    @Autowired
    private OrderService sService;

    @ApiOperation("查询订单列表、订单信息")
    @PostMapping("/getAllOrPart")
    public R getGoodsOrder(@RequestBody Order s){
        List<OrderDTO> dtos = sService.getGoodsOrderByMaiJiaId(s);

        return R.ok().put("total",dtos.size()).put("data",dtos);
    }

}
