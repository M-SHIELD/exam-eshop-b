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
import com.micah.eshop.entity.dao.RechargePlanEntity;
import com.micah.eshop.service.RechargePlanService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 充值方案表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/rechargeplan")
@Api(tags = "充值方案表接口")
@RequiredArgsConstructor
@CrossOrigin
public class RechargePlanController {
    @Autowired
    private RechargePlanService rechargePlanService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("充值方案表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rechargePlanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("充值方案表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		RechargePlanEntity rechargePlan = rechargePlanService.getById(id);

        return R.ok().put("rechargePlan", rechargePlan);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("充值方案表:保存")
    public R save(@RequestBody RechargePlanEntity rechargePlan){
		rechargePlanService.save(rechargePlan);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("充值方案表:更新")
    public R update(@RequestBody RechargePlanEntity rechargePlan){
		rechargePlanService.updateById(rechargePlan);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("充值方案表:删除")
    public R delete(@RequestBody Long[] ids){
		rechargePlanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
