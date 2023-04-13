package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.ShopEntity;

import java.util.Map;

/**
 * 店铺信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
public interface ShopService extends IService<ShopEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

