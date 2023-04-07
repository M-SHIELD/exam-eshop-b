package com.micah.goods_example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.micah.goods_example.entity.Order;
import com.micah.goods_example.entity.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderDao extends BaseMapper<Order> {

    List<OrderDTO> getGoodsOrderByMaiJiaId(Map<String,Object> map);


}
