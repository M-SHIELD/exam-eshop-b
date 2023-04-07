package com.micah.goods_example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.micah.goods_example.entity.Wallet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletDao extends BaseMapper<Wallet> {
}
