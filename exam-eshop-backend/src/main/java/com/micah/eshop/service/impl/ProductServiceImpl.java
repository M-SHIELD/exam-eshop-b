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


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

    @Override
    public PageUtils queryPage(ProductParam params) {

        QueryWrapper<ProductEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper = queryWrapper
                .like(StringUtils.isEmpty(params.getKeyWord()), "", params.getKeyWord())
                .orderBy(params.getOrder()==0,params.getOrderType()=="asc","")
                .orderBy(params.getOrder()==1,params.getOrderType()=="asc","price")
                .orderBy(params.getOrder()==2,params.getOrderType()=="asc","create_time");


        IPage<ProductEntity> iPage = new Page<>(1, 10);
        IPage<ProductEntity> page = this.page(
                iPage,
                new QueryWrapper<ProductEntity>()
        );
        return new PageUtils(page);
    }

}
