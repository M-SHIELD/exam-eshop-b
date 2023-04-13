package com.micah.eshop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.EvaluationDao;
import com.micah.eshop.entity.dao.EvaluationEntity;
import com.micah.eshop.service.EvaluationService;


@Service("evaluationService")
public class EvaluationServiceImpl extends ServiceImpl<EvaluationDao, EvaluationEntity> implements EvaluationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EvaluationEntity> iPage = new Page<>(1,10);
        IPage<EvaluationEntity> page = this.page(
                iPage,
                new QueryWrapper<EvaluationEntity>()
        );
        return new PageUtils(page);
    }

}
