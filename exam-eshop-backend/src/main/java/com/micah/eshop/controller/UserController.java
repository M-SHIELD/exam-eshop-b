package com.micah.eshop.controller;

import java.util.Arrays;
import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.micah.eshop.entity.model.LoginParam;
import com.micah.eshop.entity.model.RegisterParam;
import com.micah.eshop.util.module.GetUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import com.micah.eshop.entity.UserEntity;
import com.micah.eshop.service.UserService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * 用户表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/user")
@Api(tags = "用户表接口")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

//    /**
//     * 列表
//     */
//    @GetMapping("/list")
//    @ApiOperation("用户表:列表:自定义参数")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = userService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


//    /**
//     * 信息
//     */
//    @ApiOperation("用户表:信息:id")
//    @GetMapping("/info/{id}")
//    public R info(@PathVariable("id") Integer id){
//		UserEntity user = userService.getById(id);
//
//        return R.ok().put("user", user);
//    }


    @ApiOperation("获取用户信息")
    @PostMapping("/get")
    public R getInfo(HttpServletRequest httpServletRequest) {

        Long uid = GetUserInfo.getUid(httpServletRequest);
        return userService.getInfo(uid);
    }




    @ApiOperation("登录")
    @PostMapping("/login")
    public R login(@Valid @RequestBody LoginParam loginParam) {

        return userService.login(loginParam);
    }


    @ApiOperation("注册")
    @PostMapping("/register")
    public R register(@Valid @RequestBody RegisterParam registerParam) {

        UserEntity user = userService.getOne(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getUsername, registerParam.getUsername()), false);


        if (ObjectUtil.isNotNull(user)) {
            return R.error("用户已存在");
        }

        return userService.reg(registerParam);

    }




//    /**
//     * 保存
//     */
//    @PostMapping("/save")
//    @ApiOperation("用户表:保存")
//    public R save(@RequestBody UserEntity user){
//		userService.save(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @PostMapping("/update")
//    @ApiOperation("用户表:更新")
//    public R update(@RequestBody UserEntity user){
//		userService.updateById(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @PostMapping("/delete")
//    @ApiOperation("用户表:删除")
//    public R delete(@RequestBody Integer[] ids){
//		userService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
