package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.entity.model.OrderParam;
import com.micah.eshop.entity.vo.OrderDto;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<OrderDto> getAllOrders(OrderParam params);
}

