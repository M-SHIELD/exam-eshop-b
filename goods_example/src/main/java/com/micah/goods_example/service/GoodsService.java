package com.micah.goods_example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.goods_example.entity.Category;
import com.micah.goods_example.entity.Goods;
import com.micah.goods_example.entity.GoodsPage;
import com.micah.goods_example.entity.OrderDTO;

import java.util.List;


public interface GoodsService extends IService<Goods> {

    List<Goods> getAllGoods();

    IPage<Goods> getPageGoods(GoodsPage goodsPage);

    List<Goods> getSelectOneOrList(Goods goods);

    List<Goods> getSelectGoodsState(OrderDTO goodsStateDTO);

    Goods getSelectGoodsById(Goods goods);

    List<Goods> getGoodsListByCid(Category category);

    List<Goods> getGoodsSkuByPidAndCategoryId(Goods goods);

    Object getGoods(Goods goods);
}
