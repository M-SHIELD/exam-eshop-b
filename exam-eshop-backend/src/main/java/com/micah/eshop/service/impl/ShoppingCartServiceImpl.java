package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.ShoppingCartDao;
import com.micah.eshop.entity.ShoppingCartEntity;
import com.micah.eshop.service.ShoppingCartService;


@Service("shoppingCartService")
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartDao, ShoppingCartEntity> implements ShoppingCartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShoppingCartEntity> iPage = new Page<>(1,10);
        IPage<ShoppingCartEntity> page = this.page(
                iPage,
                new QueryWrapper<ShoppingCartEntity>()
        );
        return new PageUtils(page);
    }

}
