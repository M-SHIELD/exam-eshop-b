package com.micah.eshop.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import com.micah.eshop.entity.OrderItemEntity;
import com.micah.eshop.service.OrderItemService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 订单详情表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/orderitem")
@Api(tags = "订单详情表接口")
@RequiredArgsConstructor
@CrossOrigin
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("订单详情表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("订单详情表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OrderItemEntity orderItem = orderItemService.getById(id);

        return R.ok().put("orderItem", orderItem);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("订单详情表:保存")
    public R save(@RequestBody OrderItemEntity orderItem){
		orderItemService.save(orderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("订单详情表:更新")
    public R update(@RequestBody OrderItemEntity orderItem){
		orderItemService.updateById(orderItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("订单详情表:删除")
    public R delete(@RequestBody Long[] ids){
		orderItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
