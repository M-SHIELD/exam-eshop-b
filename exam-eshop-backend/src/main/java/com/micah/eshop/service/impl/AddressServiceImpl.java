package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.AddressDao;
import com.micah.eshop.entity.AddressEntity;
import com.micah.eshop.service.AddressService;


@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AddressEntity> iPage = new Page<>(1,10);
        IPage<AddressEntity> page = this.page(
                iPage,
                new QueryWrapper<AddressEntity>()
        );
        return new PageUtils(page);
    }

}
