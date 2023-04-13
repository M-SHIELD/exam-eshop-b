package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.RechargePlanDao;
import com.micah.eshop.entity.dao.RechargePlanEntity;
import com.micah.eshop.service.RechargePlanService;


@Service("rechargePlanService")
public class RechargePlanServiceImpl extends ServiceImpl<RechargePlanDao, RechargePlanEntity> implements RechargePlanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RechargePlanEntity> iPage = new Page<>(1,10);
        IPage<RechargePlanEntity> page = this.page(
                iPage,
                new QueryWrapper<RechargePlanEntity>()
        );
        return new PageUtils(page);
    }

}
