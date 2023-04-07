package com.micah.goods_example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.goods_example.entity.dao.User;
import com.micah.goods_example.entity.model.LoginParam;
import com.micah.goods_example.util.R;

public interface UserService extends IService<User> {

    R login(LoginParam loginParam);

}
