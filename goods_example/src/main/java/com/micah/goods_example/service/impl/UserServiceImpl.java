package com.micah.goods_example.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.goods_example.dao.UserDao;
import com.micah.goods_example.entity.bo.UserBo;
import com.micah.goods_example.entity.dao.User;
import com.micah.goods_example.entity.model.LoginParam;
import com.micah.goods_example.entity.model.RegisterParam;
import com.micah.goods_example.enums.AppFromEnum;
import com.micah.goods_example.enums.AppHttpCodeEnum;
import com.micah.goods_example.service.UserService;
import com.micah.goods_example.util.BeanCopyUtils;
import com.micah.goods_example.util.JwtUtil;
import com.micah.goods_example.util.R;
import com.micah.goods_example.util.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/7 17:01
 * @Version 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Override
    public R login(LoginParam loginParam) {
        /*查询用户是否存在*/
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper();
        lqw.eq(User::getUsername, loginParam.getUsername());
        lqw.eq(User::getPassword, loginParam.getPassword());
        User user = getOne(lqw);
        /*查询用户是否存在end*/
        if (user == null) {
            return R.error("用户不存在或密码不对");
        }
//        LocalUser.setUser(user, user.getUid());
        /*返回带信息的token*/
        UserBo userBo = BeanCopyUtils.copyBean(user, UserBo.class); /*拷贝信息*/
        String jsonEshopUserBo = JSON.toJSONString(userBo);
        /*在创建jwt的同时，将用户信息保存到本地 LocalUser中*/
        String jwt = JwtUtil.createJWT(jsonEshopUserBo);/*封装用户信息到JWT*/
        String expiration = JwtUtil.getExpiration(jwt);//获取过期时间
//        EshopUserVo eshopUserVo = BeanCopyUtils.copyBean(user, EshopUserVo.class);/*拷贝用户信息*/
        Map<String, Object> map = new HashMap<>();
        map.put("token", jwt);
        map.put("expires_time", expiration);
//        map.put("user", eshopUserVo);

        return R.ok(map).put("msg", "登录成功");

    }

    @Override
    public R reg(RegisterParam registerParam) {

        User user = new User()
                .setPassword(registerParam.getPassword())
                .setPhone(registerParam.getPhone())
                .setUsername(registerParam.getUsername())
                .setUpdateTime(new Date())
                .setIsDel(Boolean.FALSE)
                .setCreateTime(new Date())
                .setEmail(registerParam.getEmail());

        boolean save = save(user);
        if (save) {
            return R.ok("注册成功");
        }
        return R.error("注册失败");

    }
}
