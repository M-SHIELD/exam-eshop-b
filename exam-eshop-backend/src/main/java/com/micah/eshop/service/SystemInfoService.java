package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.SystemInfoEntity;

import java.util.Map;

/**
 * 系统信息存储表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
public interface SystemInfoService extends IService<SystemInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

