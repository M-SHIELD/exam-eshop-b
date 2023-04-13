package com.micah.eshop.service.impl;

import com.micah.eshop.entity.model.AddressParam;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.AddressDao;
import com.micah.eshop.entity.dao.AddressEntity;
import com.micah.eshop.service.AddressService;


@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {

    @Override
    public PageUtils queryPage(AddressParam params, Long uid) {
        QueryWrapper<AddressEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        IPage<AddressEntity> iPage = new Page<>(params.getCurrPage(), 10);
        IPage<AddressEntity> page = this.page(
                iPage,
                queryWrapper
        );
        return new PageUtils(page);
    }

}
