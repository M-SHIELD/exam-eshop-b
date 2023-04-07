package com.micah.goods_example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.goods_example.dao.OrderDao;
import com.micah.goods_example.entity.dao.Order;
import com.micah.goods_example.entity.dto.OrderDTO;
import com.micah.goods_example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Autowired
    private OrderDao sDao;

    @Override
    public List<OrderDTO> getGoodsOrderByMaiJiaId(Order s) {

        Map<String,Object> map = new HashMap<>();
        map.put("maijiaid",s.getMaijiaid());
        map.put("state",s.getState());
        map.put("订单id",s.getDdid());
        List<OrderDTO> dtos = sDao.getGoodsOrderByMaiJiaId(map);
        dtos.forEach(d->d.setPrice(d.getPrice() * d.getNumber()));
        return dtos;
    }
}
