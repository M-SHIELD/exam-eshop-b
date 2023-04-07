package com.micah.goods_example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.micah.goods_example.entity.dao.SkuValue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SkuValueDao extends BaseMapper<SkuValue> {
}
