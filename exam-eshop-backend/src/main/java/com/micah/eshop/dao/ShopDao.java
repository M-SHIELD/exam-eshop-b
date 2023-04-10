package com.micah.eshop.dao;

import com.micah.eshop.entity.ShopEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 店铺信息表
 * 
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Mapper
public interface ShopDao extends BaseMapper<ShopEntity> {
	
}
