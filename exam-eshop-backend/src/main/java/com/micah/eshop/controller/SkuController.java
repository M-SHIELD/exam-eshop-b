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
import com.micah.eshop.entity.SkuEntity;
import com.micah.eshop.service.SkuService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * SKU表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/sku")
@Api(tags = "SKU表接口")
@RequiredArgsConstructor
@CrossOrigin
public class SkuController {
    @Autowired
    private SkuService skuService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("SKU表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("SKU表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SkuEntity sku = skuService.getById(id);

        return R.ok().put("sku", sku);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("SKU表:保存")
    public R save(@RequestBody SkuEntity sku){
		skuService.save(sku);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("SKU表:更新")
    public R update(@RequestBody SkuEntity sku){
		skuService.updateById(sku);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("SKU表:删除")
    public R delete(@RequestBody Long[] ids){
		skuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
