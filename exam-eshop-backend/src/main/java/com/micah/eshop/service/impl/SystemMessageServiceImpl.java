package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.SystemMessageDao;
import com.micah.eshop.entity.SystemMessageEntity;
import com.micah.eshop.service.SystemMessageService;


@Service("systemMessageService")
public class SystemMessageServiceImpl extends ServiceImpl<SystemMessageDao, SystemMessageEntity> implements SystemMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SystemMessageEntity> iPage = new Page<>(1,10);
        IPage<SystemMessageEntity> page = this.page(
                iPage,
                new QueryWrapper<SystemMessageEntity>()
        );
        return new PageUtils(page);
    }

}
