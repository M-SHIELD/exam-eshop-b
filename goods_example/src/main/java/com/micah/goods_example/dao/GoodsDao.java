package com.micah.goods_example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.micah.goods_example.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsDao extends BaseMapper<Goods> {
    List<Goods> getSelectOneOrList(Map<String,Object> map);
    List<Goods>  getSelectGoodsState(Map<String,Object> map);

    List<Goods> getGoodsSkuByPidAndCategoryId(Map<String,Object> map);

    List<Goods> getGoodsByMap(Map<String,Object>map);
}
