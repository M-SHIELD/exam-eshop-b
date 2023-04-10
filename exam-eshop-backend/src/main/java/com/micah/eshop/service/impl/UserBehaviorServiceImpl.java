package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.UserBehaviorDao;
import com.micah.eshop.entity.UserBehaviorEntity;
import com.micah.eshop.service.UserBehaviorService;


@Service("userBehaviorService")
public class UserBehaviorServiceImpl extends ServiceImpl<UserBehaviorDao, UserBehaviorEntity> implements UserBehaviorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserBehaviorEntity> iPage = new Page<>(1,10);
        IPage<UserBehaviorEntity> page = this.page(
                iPage,
                new QueryWrapper<UserBehaviorEntity>()
        );
        return new PageUtils(page);
    }

}
