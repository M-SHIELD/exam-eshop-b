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
import com.micah.eshop.entity.ShoppingCartEntity;
import com.micah.eshop.service.ShoppingCartService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 购物车表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/shoppingcart")
@Api(tags = "购物车表接口")
@RequiredArgsConstructor
@CrossOrigin
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("购物车表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shoppingCartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("购物车表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ShoppingCartEntity shoppingCart = shoppingCartService.getById(id);

        return R.ok().put("shoppingCart", shoppingCart);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("购物车表:保存")
    public R save(@RequestBody ShoppingCartEntity shoppingCart){
		shoppingCartService.save(shoppingCart);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("购物车表:更新")
    public R update(@RequestBody ShoppingCartEntity shoppingCart){
		shoppingCartService.updateById(shoppingCart);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("购物车表:删除")
    public R delete(@RequestBody Integer[] ids){
		shoppingCartService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
