package com.micah.eshop.dao;

import com.micah.eshop.entity.WalletEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户钱包表
 * 
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Mapper
public interface WalletDao extends BaseMapper<WalletEntity> {
	
}