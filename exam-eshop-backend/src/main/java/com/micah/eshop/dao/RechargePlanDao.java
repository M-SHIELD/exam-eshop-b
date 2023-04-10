package com.micah.eshop.dao;

import com.micah.eshop.entity.RechargePlanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 充值方案表
 * 
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@Mapper
public interface RechargePlanDao extends BaseMapper<RechargePlanEntity> {
	
}
