package com.micah.goods_example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.micah.goods_example.entity.dao.Category;
import com.micah.goods_example.entity.dao.Goods;
import com.micah.goods_example.entity.dao.GoodsPage;
import com.micah.goods_example.entity.dto.OrderDTO;
import com.micah.goods_example.service.GoodsService;
import com.micah.goods_example.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName GoodsController
 * @Description 简介
 * @Author Micah
 * @Date 2022/2/27 17:27
 * @Version 1.0
 **/
@RestController
@Api(tags = "商品相关接口")
@RequestMapping("api/goods")
@CrossOrigin
public class GoodsController {
    @Resource
    GoodsService goodsService;

    @ApiOperation("查询所有商品接口//不要")
    @GetMapping("/select")
    public R select() {
        List<Goods> list = goodsService.getAllGoods();
        return R.ok().put("data", list);
    }

    @ApiOperation("分页查询商品接口//有了")
    @PostMapping("/selectPageList")
    public R selectPage(@RequestBody GoodsPage goodsPage) {
        IPage<Goods> iPage = goodsService.getPageGoods(goodsPage);
        return R.ok().put("total", iPage.getTotal()).put("data", iPage.getRecords());
    }

    @ApiOperation("根据指定条件查询//有了")
    @PostMapping("/getSelectOneOrList")
    public R getSelectOneOrList(@RequestBody Goods goods) {
        List<Goods> selectOneOrList = goodsService.getSelectOneOrList(goods);
        return R.ok().put("data", selectOneOrList);
    }

    @ApiOperation("查询买家订单信息//不要")
    @PostMapping("/getSelectGoodsState")
    public R getSelectGoodsState(@RequestBody OrderDTO goodsStateDTO) {
        List<Goods> goodsList = goodsService.getSelectGoodsState(goodsStateDTO);
        return R.ok().put("data", goodsList);
    }

    @ApiOperation("查询商品信息//不要")
    @PostMapping("/getSelectGoodsById")
    public R getSelectGoodsById(@RequestBody Goods goods) {
        return R.ok().put("data", goodsService.getSelectGoodsById(goods));
    }

    @ApiOperation("查询分类id商品列表//有了")
    @GetMapping("/getGoodsListByCid")
    public R getCategoryListByCid(@RequestBody Category category) {
        return R.ok().put("data", goodsService.getGoodsListByCid(category));
    }

    @ApiOperation("查询商品及商品规格//有了")
    @PostMapping("/getGoodsSku")
    public R getGoodsSkuByPidAndCategoryId(@RequestBody Goods goods) {
        return R.ok().put("data", goodsService.getGoodsSkuByPidAndCategoryId(goods));
    }

    @ApiOperation("根据条件查询")
    @GetMapping("/getGoods")
    public R getGoods(@RequestBody Goods goods) {
        return R.ok().put("data", goodsService.getGoods(goods));
    }
}
