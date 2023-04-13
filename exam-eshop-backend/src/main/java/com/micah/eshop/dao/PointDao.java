package com.micah.eshop.dao;

import com.micah.eshop.entity.dao.PointEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Mapper
public interface PointDao extends BaseMapper<PointEntity> {

}
