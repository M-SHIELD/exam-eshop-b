package com.micah.eshop.controller;

import java.util.Arrays;
import java.util.Map;

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
import com.micah.eshop.entity.dao.UserBehaviorEntity;
import com.micah.eshop.service.UserBehaviorService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 用户行为表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/userbehavior")
@Api(tags = "用户行为表接口")
@RequiredArgsConstructor
@CrossOrigin
public class UserBehaviorController {
    @Autowired
    private UserBehaviorService userBehaviorService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("用户行为表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userBehaviorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("用户行为表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		UserBehaviorEntity userBehavior = userBehaviorService.getById(id);

        return R.ok().put("userBehavior", userBehavior);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("用户行为表:保存")
    public R save(@RequestBody UserBehaviorEntity userBehavior){
		userBehaviorService.save(userBehavior);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("用户行为表:更新")
    public R update(@RequestBody UserBehaviorEntity userBehavior){
		userBehaviorService.updateById(userBehavior);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("用户行为表:删除")
    public R delete(@RequestBody Long[] ids){
		userBehaviorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
