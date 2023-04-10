package com.micah.eshop.dao;

import com.micah.eshop.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * 
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
