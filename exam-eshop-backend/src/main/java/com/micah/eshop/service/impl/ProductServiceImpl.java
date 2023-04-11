package com.micah.eshop.service.impl;

import com.micah.eshop.entity.model.ProductParam;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.ProductDao;
import com.micah.eshop.entity.ProductEntity;
import com.micah.eshop.service.ProductService;
import org.springframework.util.StringUtils;

import java.util.Objects;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

    @Override
    public PageUtils queryPage(ProductParam params) {

        QueryWrapper<ProductEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper = queryWrapper
                .eq("is_show",1)
                .eq("is_integral",params.getIsIntegral())
                .eq("status",params.getStatus())
                .eq("is_hot",params.getIsHot())
                .like(!StringUtils.isEmpty(params.getKeyWord()), "name", params.getKeyWord())
                .orderBy(params.getOrder()==0, Objects.equals(params.getOrderType(), "asc"),"id")
                .orderBy(params.getOrder()==1, Objects.equals(params.getOrderType(), "asc"),"price")
                .orderBy(params.getOrder()==2, Objects.equals(params.getOrderType(), "asc"),"create_time");


        IPage<ProductEntity> iPage = new Page<>(params.getCurrPage(), 10);
        IPage<ProductEntity> page = this.page(
                iPage,
                queryWrapper
        );
        return new PageUtils(page);
    }

}
