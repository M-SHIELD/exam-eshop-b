package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.RechargePlanEntity;

import java.util.Map;

/**
 * 充值方案表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface RechargePlanService extends IService<RechargePlanEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

