package com.micah.eshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.eshop.entity.model.UserBehaviorParam;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.entity.dao.UserBehaviorEntity;

import java.util.Map;

/**
 * 用户行为表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
public interface UserBehaviorService extends IService<UserBehaviorEntity> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     * 判断该用户行为是否存在
     * @param productId 商品id
     * @param uid 用户id
     * @param behaviorType 行为类型
     * @return 是否存在
     */
    Boolean behaviorExist(Long productId, Long uid,Integer behaviorType);


    Boolean addBehavior(UserBehaviorParam param, Long uid);

    Boolean delBehavior(UserBehaviorParam param, Long uid);

    PageUtils getBehaviors(Integer current, Long uid, Integer behaviorType);

}

