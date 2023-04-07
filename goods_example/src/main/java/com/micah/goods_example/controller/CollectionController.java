package com.micah.goods_example.controller;

import com.micah.goods_example.entity.dao.Collection;
import com.micah.goods_example.service.CollectionService;
import com.micah.goods_example.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "收藏夹相关接口")
@CrossOrigin
@RequestMapping("api/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @ApiOperation("查看买家收藏列表")
    @PostMapping("/All")
    public R getAllCollection(@RequestBody Collection collection){
        return R.ok().put("data",collectionService.getAllCollectionByMaijiaId(collection));
    }

    @ApiOperation("加入、取消收藏")
    @RequestMapping("/setCollection")
    public R setCollection(@RequestBody Collection collection){
        return R.ok().put("msg",collectionService.CollectionGoods(collection));

    }
}
