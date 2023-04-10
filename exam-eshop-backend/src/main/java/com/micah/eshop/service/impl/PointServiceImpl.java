package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.PointDao;
import com.micah.eshop.entity.PointEntity;
import com.micah.eshop.service.PointService;


@Service("pointService")
public class PointServiceImpl extends ServiceImpl<PointDao, PointEntity> implements PointService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PointEntity> iPage = new Page<>(1,10);
        IPage<PointEntity> page = this.page(
                iPage,
                new QueryWrapper<PointEntity>()
        );
        return new PageUtils(page);
    }

}
