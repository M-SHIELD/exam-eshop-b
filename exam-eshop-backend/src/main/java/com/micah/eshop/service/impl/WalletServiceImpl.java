package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;

import com.micah.eshop.dao.WalletDao;
import com.micah.eshop.entity.dao.WalletEntity;
import com.micah.eshop.service.WalletService;


@Service("walletService")
public class WalletServiceImpl extends ServiceImpl<WalletDao, WalletEntity> implements WalletService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WalletEntity> iPage = new Page<>(1,10);
        IPage<WalletEntity> page = this.page(
                iPage,
                new QueryWrapper<WalletEntity>()
        );
        return new PageUtils(page);
    }

}
