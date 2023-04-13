package com.micah.eshop.dao;

import com.micah.eshop.entity.dao.AddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 收货地址表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Mapper
public interface AddressDao extends BaseMapper<AddressEntity> {

}
