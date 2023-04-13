package com.micah.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.micah.eshop.entity.model.UserBehaviorParam;
import com.micah.eshop.enums.AppHttpCodeEnum;
import com.micah.eshop.handler.SystemException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.UserBehaviorDao;
import com.micah.eshop.entity.dao.UserBehaviorEntity;
import com.micah.eshop.service.UserBehaviorService;


@Service("userBehaviorService")
public class UserBehaviorServiceImpl extends ServiceImpl<UserBehaviorDao, UserBehaviorEntity> implements UserBehaviorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserBehaviorEntity> iPage = new Page<>(1, 10);
        IPage<UserBehaviorEntity> page = this.page(
                iPage,
                new QueryWrapper<UserBehaviorEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public Boolean behaviorExist(Long productId, Long uid, Integer behaviorType) {

        LambdaQueryWrapper<UserBehaviorEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserBehaviorEntity::getUserId, uid)
                .eq(UserBehaviorEntity::getBehaviorType, behaviorType)
                .eq(UserBehaviorEntity::getProductId, productId);
        long count = count(wrapper);
        return count > 0L;

    }

    @Override
    public Boolean addBehavior(UserBehaviorParam param, Long uid) {

        //判断是否存在
        if (behaviorExist(Long.valueOf(param.getProductId()), uid, param.getBehaviorType())) {
            throw new SystemException(AppHttpCodeEnum.FAIL,"该类型已存在");
        }

        UserBehaviorEntity userBehaviorEntity = new UserBehaviorEntity();
        userBehaviorEntity
                .setUserId(uid)
                .setProductId(Long.valueOf(param.getProductId()))
                .setBehaviorType(param.getBehaviorType())
                .setCreateTime(new Date())
                .setUpdateTime(new Date())
                .setIsDel(0)
        ;

        return save(userBehaviorEntity);
    }

    @Override
    public Boolean delBehavior(UserBehaviorParam param, Long uid) {

        LambdaQueryWrapper<UserBehaviorEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserBehaviorEntity::getUserId, uid)
                .eq(UserBehaviorEntity::getBehaviorType, param.getBehaviorType())
                .eq(UserBehaviorEntity::getProductId, param.getProductId());

        UserBehaviorEntity one = getOne(wrapper);
        if (one == null) {
            throw new SystemException(AppHttpCodeEnum.FAIL,"该类型不存在");
        }

        //获取id删除

        return removeById(one.getId());
    }

    @Override
    public PageUtils getBehaviors(Integer current, Long uid, Integer behaviorType) {

        //分页查询

        IPage<UserBehaviorEntity> iPage = new Page<>(current, 10);

        QueryWrapper<UserBehaviorEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper = queryWrapper.eq("user_id", uid).eq("behavior_type", behaviorType);

        IPage<UserBehaviorEntity> page = this.page(
                iPage,
                queryWrapper
        );

        return new PageUtils(page);
    }

}
