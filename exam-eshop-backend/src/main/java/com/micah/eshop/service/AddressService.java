package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.entity.model.AddressParam;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.AddressEntity;

/**
 * 收货地址表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface AddressService extends IService<AddressEntity> {

    PageUtils queryPage(AddressParam params, Long uid);
}

