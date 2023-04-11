package com.micah.eshop.controller;

import java.util.List;

import com.micah.eshop.entity.model.OrderParam;
import com.micah.eshop.entity.vo.OrderDto;
import com.micah.eshop.util.module.GetUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import com.micah.eshop.service.OrderService;
import com.micah.eshop.util.R;

import javax.servlet.http.HttpServletRequest;


/**
 * 订单表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/order")
@Api(tags = "订单表接口")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/getAllOrders")
    @ApiOperation("获取所有订单列表")
    public R getAllOrders(@RequestBody OrderParam params, HttpServletRequest request) {

        //设置uid
        Long uid= GetUserInfo.getUid(request);
        params.setUid(uid);
        //查询数据
        List<OrderDto> list=orderService.getAllOrders(params);

        return R.ok().put("data", list);
    }


//    /**
//     * 列表
//     */
//    @GetMapping("/list")
//    @ApiOperation("订单表:列表:自定义参数")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = orderService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @ApiOperation("订单表:信息:id")
//    @GetMapping("/info/{id}")
//    public R info(@PathVariable("id") Long id){
//		OrderEntity order = orderService.getById(id);
//
//        return R.ok().put("order", order);
//    }
//
//    /**
//     * 保存
//     */
//    @PostMapping("/save")
//    @ApiOperation("订单表:保存")
//    public R save(@RequestBody OrderEntity order){
//		orderService.save(order);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @PostMapping("/update")
//    @ApiOperation("订单表:更新")
//    public R update(@RequestBody OrderEntity order){
//		orderService.updateById(order);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @PostMapping("/delete")
//    @ApiOperation("订单表:删除")
//    public R delete(@RequestBody Long[] ids){
//		orderService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
