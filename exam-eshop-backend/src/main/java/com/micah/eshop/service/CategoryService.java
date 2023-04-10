package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.entity.model.PageParam;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品分类表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(PageParam params);

    List<CategoryEntity> getAllCategory();
}

