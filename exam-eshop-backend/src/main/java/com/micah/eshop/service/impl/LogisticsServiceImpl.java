package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.LogisticsDao;
import com.micah.eshop.entity.dao.LogisticsEntity;
import com.micah.eshop.service.LogisticsService;


@Service("logisticsService")
public class LogisticsServiceImpl extends ServiceImpl<LogisticsDao, LogisticsEntity> implements LogisticsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LogisticsEntity> iPage = new Page<>(1,10);
        IPage<LogisticsEntity> page = this.page(
                iPage,
                new QueryWrapper<LogisticsEntity>()
        );
        return new PageUtils(page);
    }

}
