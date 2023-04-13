package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.EvaluationEntity;

import java.util.Map;

/**
 * 评价表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface EvaluationService extends IService<EvaluationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

