package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.UserBehaviorEntity;

import java.util.Map;

/**
 * 用户行为表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface UserBehaviorService extends IService<UserBehaviorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

