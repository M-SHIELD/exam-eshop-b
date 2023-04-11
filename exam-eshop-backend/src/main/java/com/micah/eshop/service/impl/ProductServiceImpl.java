package com.micah.eshop.service.impl;

import com.micah.eshop.entity.SkuEntity;
import com.micah.eshop.entity.UserBehaviorEntity;
import com.micah.eshop.entity.model.ProductParam;
import com.micah.eshop.entity.vo.ProductDto;
import com.micah.eshop.service.SkuService;
import com.micah.eshop.service.UserBehaviorService;
import com.micah.eshop.util.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;
import java.util.Objects;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

    @Autowired
    SkuService skuService;
    @Autowired
    UserBehaviorService userBehaviorService;

    @Override
    public PageUtils queryPage(ProductParam params) {

        QueryWrapper<ProductEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper = queryWrapper
                .eq("is_show", 1)
                .eq("is_integral", params.getIsIntegral())
                .eq("status", params.getStatus())
                .eq("is_hot", params.getIsHot())
                .like(!StringUtils.isEmpty(params.getKeyWord()), "name", params.getKeyWord())
                .orderBy(params.getOrder() == 0, Objects.equals(params.getOrderType(), "asc"), "id")
                .orderBy(params.getOrder() == 1, Objects.equals(params.getOrderType(), "asc"), "price")
                .orderBy(params.getOrder() == 2, Objects.equals(params.getOrderType(), "asc"), "create_time");


        IPage<ProductEntity> iPage = new Page<>(params.getCurrPage(), 10);
        IPage<ProductEntity> page = this.page(
                iPage,
                queryWrapper
        );
        return new PageUtils(page);
    }

    @Override
    public ProductDto details(String id, Long uid) {

        //查询本身

        ProductEntity byId = getById(id);
        ProductDto productDto = BeanCopyUtils.copyBean(byId, ProductDto.class);

        //sku
        QueryWrapper<SkuEntity> skuEntityQueryWrapper = new QueryWrapper<>();
        skuEntityQueryWrapper = skuEntityQueryWrapper.eq("product_id", productDto.getId()).eq("is_del", 0);
        List<SkuEntity> skuEntities = skuService.list(skuEntityQueryWrapper);
        productDto.setSkus(skuEntities);


        //查询收藏
        QueryWrapper<UserBehaviorEntity> userBehaviorEntityQueryWrapper = new QueryWrapper<>();
        userBehaviorEntityQueryWrapper = userBehaviorEntityQueryWrapper
                .eq("product_id", productDto.getId())
                .eq("behavior_type", 1)
                .eq("user_id", uid)
                .eq("is_del", 0);
        UserBehaviorEntity userBehaviorEntity = userBehaviorService.getOne(userBehaviorEntityQueryWrapper);

        productDto.setIsCollect(userBehaviorEntity != null);


        return productDto;

    }

}
