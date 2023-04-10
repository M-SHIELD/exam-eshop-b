package com.micah.eshop.dao;

import com.micah.eshop.entity.SystemInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统信息存储表
 * 
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@Mapper
public interface SystemInfoDao extends BaseMapper<SystemInfoEntity> {
	
}
