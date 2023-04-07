package com.micah.goods_example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.goods_example.entity.dao.Order;
import com.micah.goods_example.entity.dto.OrderDTO;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<OrderDTO> getGoodsOrderByMaiJiaId(Order s);
}
