package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.entity.model.ProductParam;
import com.micah.eshop.entity.vo.ProductDto;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.ProductEntity;

/**
 * 商品信息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface ProductService extends IService<ProductEntity> {

    PageUtils queryPage(ProductParam params);

    ProductDto details(String id, Long uid);
}

