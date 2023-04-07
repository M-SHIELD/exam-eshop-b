package com.micah.goods_example.controller;

import com.micah.goods_example.entity.model.LoginParam;
import com.micah.goods_example.service.UserService;
import com.micah.goods_example.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public R getSelectWallet(@RequestBody LoginParam loginParam) {

        return userService.login(loginParam);
    }


}
