package com.micah.goods_example.controller;

import com.micah.goods_example.entity.Category;
import com.micah.goods_example.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "商品分类相关接口")
@RequestMapping("/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @ApiOperation("一级分类")
    @GetMapping("/getSelectCategoryAll")
    public List<Category> getSelectCategoryAll(){
        return categoryService.getSelectCategoryAll();
    }

    @GetMapping("/select")
    public List<Category> select(){
        List<Category> list= categoryService.getCategoryList();
        return list;
    }


}
