package com.micah.goods_example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.micah.goods_example.entity.dao.User;
import com.micah.goods_example.entity.model.LoginParam;
import com.micah.goods_example.entity.model.RegisterParam;
import com.micah.goods_example.service.UserService;
import com.micah.goods_example.util.R;
import com.micah.goods_example.util.module.GetUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @ClassName UserController
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/7 17:04
 * @Version 1.0
 **/
@RestController
@Api(tags = "用户接口")
@RequestMapping("api/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation("登录")
    @PostMapping("/login")
    public R login(@Valid @RequestBody LoginParam loginParam) {

        return userService.login(loginParam);
    }

    @ApiOperation("获取用户信息")
    @PostMapping("/get")
    public R getInfo(HttpServletRequest httpServletRequest) {

        Long uid = GetUserInfo.getUid(httpServletRequest);
        return userService.getInfo(uid);
    }



    @ApiOperation("注册")
    @PostMapping("/register")
    public R register(@Valid @RequestBody RegisterParam registerParam) {

        User user = userService.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUsername, registerParam.getUsername()), false);


        if (ObjectUtil.isNotNull(user)) {
            return R.error("用户已存在");
        }

        return userService.reg(registerParam);

    }


}
