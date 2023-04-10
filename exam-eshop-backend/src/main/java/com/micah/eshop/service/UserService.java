package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.entity.model.LoginParam;
import com.micah.eshop.entity.model.RegisterParam;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.UserEntity;
import com.micah.eshop.util.R;

import java.util.Map;

/**
 * 用户表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R login(LoginParam loginParam);

    R reg(RegisterParam registerParam);

    R getInfo(Long uid);
}

