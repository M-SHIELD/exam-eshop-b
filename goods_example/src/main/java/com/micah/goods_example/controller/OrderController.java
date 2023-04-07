package com.micah.goods_example.controller;

import com.micah.goods_example.entity.dao.Order;
import com.micah.goods_example.entity.dto.OrderDTO;
import com.micah.goods_example.service.OrderService;
import com.micah.goods_example.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "商品订单相关接口")
@CrossOrigin
@RequestMapping("api/order")
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
