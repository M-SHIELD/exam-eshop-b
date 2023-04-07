package com.micah.goods_example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.goods_example.dao.CollectionDao;
import com.micah.goods_example.entity.dao.Collection;
import com.micah.goods_example.entity.dao.Goods;
import com.micah.goods_example.service.CollectionService;
import com.micah.goods_example.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionDao, Collection> implements CollectionService {

    @Autowired
    private CollectionDao collectionDao;

    @Resource
    private GoodsService goodsService;

    @Override
    public List<Collection> getAllCollectionByMaijiaId(Collection collection) {

        Map<String, Object> map = new HashMap<>();
        map.put("maiJiaId", collection.getMaiJiaId());
        return collectionDao.getAllCollectionByMaijiaId(map);
    }

    @Override
    public String CollectionGoods(Collection collection) {

        //收藏状态
        String msg;
        /**
         * @var 根据买家id、商品id查询收藏商品信息
         */
        Collection collectionList = this.baseMapper.selectOne(new QueryWrapper<Collection>()
                .eq("goods_id", collection.getGoodsId())
                .eq("maijia_id", collection.getMaiJiaId()));

        if (collectionList != null) {
            /**
             * @var 有
             *  根据买家Id和商品Id删除
             */
            this.baseMapper.delete(new QueryWrapper<Collection>()
                    .eq("goods_id", collection.getGoodsId())
                    .eq("maijia_id", collection.getMaiJiaId()));
            msg = "取消收藏";
        } else {
            /**
             * @var 没有
             *  获取商品name
             *  插入
             */
            Goods goods = goodsService.getById(collection.getGoodsId());
            collection.setGoodsName(goods.getPname());
            this.baseMapper.insert(collection);
            msg = "加入收藏";
        }

        return msg;
    }
}
