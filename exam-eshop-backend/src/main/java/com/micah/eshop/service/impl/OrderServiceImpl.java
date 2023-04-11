package com.micah.eshop.service.impl;


import com.micah.eshop.entity.OrderItemEntity;
import com.micah.eshop.entity.ShopEntity;
import com.micah.eshop.entity.model.OrderParam;
import com.micah.eshop.entity.vo.OrderDto;
import com.micah.eshop.service.OrderItemService;
import com.micah.eshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.OrderDao;
import com.micah.eshop.entity.OrderEntity;
import com.micah.eshop.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ShopService shopService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> iPage = new Page<>(1, 10);
        IPage<OrderEntity> page = this.page(
                iPage,
                new QueryWrapper<>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<OrderDto> getAllOrders(OrderParam params) {

        List<OrderDto> orderDtos = new ArrayList<>();

        //查询当前用户所有的订单
        //获取用户id
        QueryWrapper<OrderEntity> orderQueryWrapper = new QueryWrapper<OrderEntity>().eq("uid", params.getUid());
        //判断params里的status是否为-1 是则查询所有
        if (params.getStatus() != -1) {
            orderQueryWrapper = orderQueryWrapper.eq("status", params.getStatus());
        }

        //查询出来所有的订单
        List<OrderEntity> orderList = this.list(orderQueryWrapper);


        //查询对应订单所拥有的商品详情

        orderList.forEach(e -> {

            OrderDto orderDto = new OrderDto();
            orderDto.setId(e.getId());
            orderDto.setOrderNo(e.getOrderNo());
            orderDto.setUid(e.getUid());
            orderDto.setTotalAmount(e.getTotalAmount());
            orderDto.setPayAmount(e.getPayAmount());
            orderDto.setPayType(e.getPayType());
            orderDto.setStatus(e.getStatus());
            orderDto.setCreateTime(e.getCreateTime());
            orderDto.setUpdateTime(e.getUpdateTime());
            orderDto.setIsDel(e.getIsDel());

            //插入店铺名称

            ShopEntity shopById = shopService.getById(e.getShopId());
            orderDto.setShopName(shopById.getShopName());

            //查询插入商品详情

            QueryWrapper<OrderItemEntity> orderItemEntityQueryWrapper = new QueryWrapper<>();
            orderItemEntityQueryWrapper = orderItemEntityQueryWrapper.eq("order_id", e.getId()).eq("is_del", 0);
            List<OrderItemEntity> list = orderItemService.list(orderItemEntityQueryWrapper);
            orderDto.setProducts(list);
            orderDtos.add(orderDto);


        });

        return orderDtos;

    }

}
