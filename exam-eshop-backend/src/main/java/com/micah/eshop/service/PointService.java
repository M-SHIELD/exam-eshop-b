package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.PointEntity;

import java.util.Map;

/**
 * 积分表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
public interface PointService extends IService<PointEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

