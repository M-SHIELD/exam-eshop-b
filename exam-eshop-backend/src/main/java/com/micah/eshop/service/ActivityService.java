package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.ActivityEntity;

import java.util.Map;

/**
 * 活动信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
public interface ActivityService extends IService<ActivityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

