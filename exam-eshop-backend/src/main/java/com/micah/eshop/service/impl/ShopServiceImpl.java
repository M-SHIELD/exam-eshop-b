package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.ShopDao;
import com.micah.eshop.entity.ShopEntity;
import com.micah.eshop.service.ShopService;


@Service("shopService")
public class ShopServiceImpl extends ServiceImpl<ShopDao, ShopEntity> implements ShopService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShopEntity> iPage = new Page<>(1,10);
        IPage<ShopEntity> page = this.page(
                iPage,
                new QueryWrapper<ShopEntity>()
        );
        return new PageUtils(page);
    }

}
