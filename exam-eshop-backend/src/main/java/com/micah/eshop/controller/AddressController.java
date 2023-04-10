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
import com.micah.eshop.entity.AddressEntity;
import com.micah.eshop.service.AddressService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 收货地址表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/address")
@Api(tags = "收货地址表接口")
@RequiredArgsConstructor
@CrossOrigin
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("收货地址表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = addressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("收货地址表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		AddressEntity address = addressService.getById(id);

        return R.ok().put("address", address);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("收货地址表:保存")
    public R save(@RequestBody AddressEntity address){
		addressService.save(address);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("收货地址表:更新")
    public R update(@RequestBody AddressEntity address){
		addressService.updateById(address);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("收货地址表:删除")
    public R delete(@RequestBody Integer[] ids){
		addressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
