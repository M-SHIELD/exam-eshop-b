package com.micah.eshop.dao;

import com.micah.eshop.entity.dao.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单详情表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {

}
