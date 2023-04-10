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
import com.micah.eshop.entity.ProductEntity;
import com.micah.eshop.service.ProductService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 商品信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/product")
@Api(tags = "商品信息表接口")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("商品信息表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("商品信息表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ProductEntity product = productService.getById(id);

        return R.ok().put("product", product);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("商品信息表:保存")
    public R save(@RequestBody ProductEntity product){
		productService.save(product);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("商品信息表:更新")
    public R update(@RequestBody ProductEntity product){
		productService.updateById(product);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("商品信息表:删除")
    public R delete(@RequestBody Long[] ids){
		productService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
