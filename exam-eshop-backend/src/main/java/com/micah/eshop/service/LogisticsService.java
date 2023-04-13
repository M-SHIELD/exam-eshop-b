package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.LogisticsEntity;

import java.util.Map;

/**
 * 物流信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
public interface LogisticsService extends IService<LogisticsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

