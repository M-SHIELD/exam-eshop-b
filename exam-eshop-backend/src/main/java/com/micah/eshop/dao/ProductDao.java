package com.micah.eshop.dao;

import com.micah.eshop.entity.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品信息表
 * 
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
	
}
