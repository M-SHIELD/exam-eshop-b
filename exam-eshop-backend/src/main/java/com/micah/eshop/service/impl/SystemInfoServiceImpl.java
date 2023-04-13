package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.SystemInfoDao;
import com.micah.eshop.entity.dao.SystemInfoEntity;
import com.micah.eshop.service.SystemInfoService;


@Service("systemInfoService")
public class SystemInfoServiceImpl extends ServiceImpl<SystemInfoDao, SystemInfoEntity> implements SystemInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SystemInfoEntity> iPage = new Page<>(1,10);
        IPage<SystemInfoEntity> page = this.page(
                iPage,
                new QueryWrapper<SystemInfoEntity>()
        );
        return new PageUtils(page);
    }

}
