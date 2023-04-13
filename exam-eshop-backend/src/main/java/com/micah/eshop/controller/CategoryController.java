package com.micah.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import com.micah.eshop.service.CategoryService;
import com.micah.eshop.util.R;


/**
 * 商品分类表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@RestController
@RequestMapping("api/category")
@Api(tags = "商品分类表接口")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/select")
    @ApiOperation("商品分类表:列表:获取所有分类")
    public R select() {


        return R.ok().put("data", categoryService.getAllCategory());


    }

//    /**
//     * 列表
//     */
//    @PostMapping("/list")
//    @ApiOperation("商品分类表:列表:自定义参数")
//    public R list(@RequestBody PageParam params){
//        PageUtils page = categoryService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @ApiOperation("商品分类表:信息:id")
//    @GetMapping("/info/{id}")
//    public R info(@PathVariable("id") Integer id){
//		CategoryEntity category = categoryService.getById(id);
//
//        return R.ok().put("category", category);
//    }
//
//    /**
//     * 保存
//     */
//    @PostMapping("/save")
//    @ApiOperation("商品分类表:保存")
//    public R save(@RequestBody CategoryEntity category){
//		categoryService.save(category);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @PostMapping("/update")
//    @ApiOperation("商品分类表:更新")
//    public R update(@RequestBody CategoryEntity category){
//		categoryService.updateById(category);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @PostMapping("/delete")
//    @ApiOperation("商品分类表:删除")
//    public R delete(@RequestBody Integer[] ids){
//		categoryService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
