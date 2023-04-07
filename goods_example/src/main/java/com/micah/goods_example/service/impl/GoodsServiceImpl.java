package com.micah.goods_example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.goods_example.dao.GoodsDao;
import com.micah.goods_example.dao.SkuKeyDao;
import com.micah.goods_example.dao.SkuValueDao;
import com.micah.goods_example.entity.*;
import com.micah.goods_example.enums.GoodsOrderByEnum;
import com.micah.goods_example.service.GoodsService;
import com.micah.goods_example.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsService
 * @Description 简介
 * @Author Micah
 * @Date 2022/2/27 17:26
 * @Version 1.0
 **/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private SkuKeyDao skuKeyDao;

    @Resource
    private SkuValueDao skuValueDao;

    @Override
    public List<Goods> getAllGoods() {
        return this.baseMapper.selectList(new QueryWrapper<Goods>());
    }

    public IPage<Goods> getPageGoods(GoodsPage goodsPage) {

        IPage<Goods> iPage;
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        //  是否为积分商城
        wrapper.eq("isfictitious", goodsPage.getIsfictitious());
        // 升降排序
        if (goodsPage.getColumnName() != null) {
            if (goodsPage.getDescOrAsc() == 0) {
                wrapper.orderByAsc(goodsPage.getColumnName());
            } else if (goodsPage.getDescOrAsc() == 1) {
                wrapper.orderByDesc(goodsPage.getColumnName());
            }
        }
        // 商品分类
        if (goodsPage.getCategoryId() != null) {
            wrapper.eq("category_id", goodsPage.getCategoryId());
        }
        // 分页
        if (goodsPage.getCurrent() == null || goodsPage.getSize() == null) {
            iPage = this.baseMapper.selectPage(new Page<>(0, 9), wrapper);
        } else {
            iPage = this.baseMapper.selectPage(new Page<>(goodsPage.getCurrent(), goodsPage.getSize()), wrapper);
        }
        return iPage;
    }

    public List<Goods> getSelectOneOrList(Goods goods) {
        Map<String, Object> map = new HashMap<>();
        map.put("pid", goods.getPid());
        map.put("pname", goods.getPname());
        map.put("price", goods.getPrice());
        map.put("flag", goods.getFlag());
        map.put("categoryId", goods.getCategoryId());
        List<Goods> selectOne = goodsDao.getSelectOneOrList(map);
        return selectOne;
    }

    public List<Goods> getSelectGoodsState(OrderDTO goodsStateDTO) {

        Map<String, Object> map = new HashMap<>();
        map.put("maijiaid", goodsStateDTO.getMaijiaid());
        map.put("state", goodsStateDTO.getState());
        map.put("isEnd", goodsStateDTO.getIsEnd());
        if (goodsStateDTO.getCurrent() == null && goodsStateDTO.getSize() == null) {
            goodsStateDTO.setCurrent(0);
            goodsStateDTO.setSize(9);
            map.put("current", goodsStateDTO.getCurrent());
            map.put("size", goodsStateDTO.getSize());
        } else {
            map.put("current", goodsStateDTO.getCurrent());
            map.put("size", goodsStateDTO.getSize());
        }
        List<Goods> goodsList = goodsDao.getSelectGoodsState(map);

        return goodsList;
    }

    public Goods getSelectGoodsById(Goods goods) {
        Goods goodsbyId = this.baseMapper.selectById(goods.getPid());
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pid", goods.getPid())
                .set("browse", 1);
        return goodsbyId;
    }

    public List<Goods> getGoodsListByCid(Category category) {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", category.getCid());
        return this.baseMapper.selectList(wrapper);
    }

    public List<Goods> getGoodsSkuByPidAndCategoryId(Goods goods) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", goods.getPid());
        map.put("cid", goods.getCategoryId());
        List<Goods> goodssku = goodsDao.getGoodsSkuByPidAndCategoryId(map);
        return goodssku;
    }

    public Object getGoods(Goods goods) {

        IPage<Goods> iPage;
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();
        //  是否为积分商城
        wrapper.eq(Goods::getIsfictitious, goods.getIsfictitious());
        // 升降排序/指定条件
        if (goods.getDescOrAsc() != null) {
            switch (goods.getDescOrAsc()) {
                case 0:
                    wrapper.orderByAsc(GoodsOrderByEnum.valueOf(goods.getOrderBy()) == GoodsOrderByEnum.DEFAULT, Goods::getPid);   //默认
                    wrapper.orderByAsc(GoodsOrderByEnum.valueOf(goods.getOrderBy()) == GoodsOrderByEnum.NEW, Goods::getFlag);      //新品
                    wrapper.orderByAsc(GoodsOrderByEnum.valueOf(goods.getOrderBy()) == GoodsOrderByEnum.PRICE, Goods::getPrice);   //价格
                    break;
                case 1:
                    wrapper.orderByDesc(GoodsOrderByEnum.valueOf(goods.getOrderBy()) == GoodsOrderByEnum.DEFAULT, Goods::getPid);
                    wrapper.orderByDesc(GoodsOrderByEnum.valueOf(goods.getOrderBy()) == GoodsOrderByEnum.NEW, Goods::getFlag);
                    wrapper.orderByDesc(GoodsOrderByEnum.valueOf(goods.getOrderBy()) == GoodsOrderByEnum.PRICE, Goods::getPrice);
                    break;
            }
        }
        // 商品分类
        wrapper.eq(goods.getCategoryId() != null, Goods::getCategoryId, goods.getCategoryId());
        // 分页
        if (goods.getCurrent() == null || goods.getSize() == null) {
            iPage = this.baseMapper.selectPage(new Page<>(0, 9), wrapper);
        } else {
            iPage = this.baseMapper.selectPage(new Page<>(goods.getCurrent(), goods.getSize()), wrapper);
        }
        //查询商品及商品规格
        if (goods.getPid() != null){
            /**
             *
             */
            //region 查询商品
            Goods getGoods = this.baseMapper.selectOne(new QueryWrapper<Goods>().eq("pid",goods.getPid()));
            List<SkuKey> getSkuKey = skuKeyDao.selectList(new QueryWrapper<SkuKey>().eq("category_id", getGoods.getCategoryId()));
            List<SkuValue> getSkuValue = skuValueDao.selectList(new QueryWrapper<SkuValue>().eq("sku_key_id", getSkuKey.get(0).getId()));
            getGoods.setSkuValues(getSkuKey.get(0).getSkuValues());
            getGoods.setSkuValue(getSkuValue.get(0).getSkuValue());
            //endregion

            return R.ok().put("data",getGoods);
        }

        return iPage;
    }
}
