package com.micah.eshop.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.micah.eshop.entity.bo.UserBo;
import com.micah.eshop.entity.model.LoginParam;
import com.micah.eshop.entity.model.RegisterParam;
import com.micah.eshop.enums.AppHttpCodeEnum;
import com.micah.eshop.util.BeanCopyUtils;
import com.micah.eshop.util.JwtUtil;
import com.micah.eshop.util.R;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.UserDao;
import com.micah.eshop.entity.dao.UserEntity;
import com.micah.eshop.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> iPage = new Page<>(1, 10);
        IPage<UserEntity> page = this.page(
                iPage,
                new QueryWrapper<>()
        );
        return new PageUtils(page);
    }


    @Override
    public R login(LoginParam loginParam) {
        /*查询用户是否存在*/
        LambdaQueryWrapper<UserEntity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(UserEntity::getUsername, loginParam.getUsername());
        lqw.eq(UserEntity::getPassword, loginParam.getPassword());
        UserEntity user = getOne(lqw);
        /*查询用户是否存在end*/
        if (user == null) {
            return R.error("用户不存在或密码不对");
        }
        if (user.getIsDel() == 1) {
            return R.error("用户已被封禁或删除");
        }

        //将需要存储的信息放入到jwt内
        /*拷贝信息*/
        UserBo userBo = BeanCopyUtils.copyBean(user, UserBo.class);
        userBo.setUid(user.getId());
        String jsonEshopUserBo = JSON.toJSONString(userBo);
        /*封装用户信息到JWT*/
        String jwt = JwtUtil.createJWT(jsonEshopUserBo);
        //获取过期时间
        String expiration = JwtUtil.getExpiration(jwt);


        Map<String, Object> map = new HashMap<>();
        map.put("token", jwt);
        map.put("expires_time", expiration);
        map.put("avator", user.getAvator());

        return R.ok(map).put("msg", "登录成功");

    }

    @Override
    public R reg(RegisterParam registerParam) {

        UserEntity user = new UserEntity()
                .setPassword(registerParam.getPassword())
                .setPhone(registerParam.getPhone())
                .setUsername(registerParam.getUsername())
                .setUpdateTime(new Date())
                .setIsDel(0)
                .setCreateTime(new Date())
                .setAvator("https://th.bing.com/th/id/R.629105f8e48009c659b8a4048adef1cc?rik=0LttQdHqnl3ang&riu=http%3a%2f%2fimg.wxcha.com%2ffile%2f202005%2f19%2fdeb4d01b77.jpg&ehk=6DKzNVR5O4Oa%2fZxvhM9ea0W9jpJVSfAZVW4mPemcz3k%3d&risl=&pid=ImgRaw&r=0")
                .setEmail(registerParam.getEmail());


        boolean save = save(user);
        if (save) {
            return R.ok("注册成功");
        }
        return R.init(AppHttpCodeEnum.NO_REGISTER_SUCCESS);

    }

    @Override
    public R getInfo(Long uid) {
        LambdaQueryWrapper<UserEntity> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(UserEntity::getId, uid);
        UserEntity one = getOne(userLambdaQueryWrapper);
        one.setPassword("");
        return R.ok().put("data", one);
    }

}
