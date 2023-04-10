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
import com.micah.eshop.entity.SystemInfoEntity;
import com.micah.eshop.service.SystemInfoService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 系统信息存储表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@RestController
@RequestMapping("api/systeminfo")
@Api(tags = "系统信息存储表接口")
@RequiredArgsConstructor
@CrossOrigin
public class SystemInfoController {
    @Autowired
    private SystemInfoService systemInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("系统信息存储表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = systemInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("系统信息存储表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SystemInfoEntity systemInfo = systemInfoService.getById(id);

        return R.ok().put("systemInfo", systemInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("系统信息存储表:保存")
    public R save(@RequestBody SystemInfoEntity systemInfo){
		systemInfoService.save(systemInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("系统信息存储表:更新")
    public R update(@RequestBody SystemInfoEntity systemInfo){
		systemInfoService.updateById(systemInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("系统信息存储表:删除")
    public R delete(@RequestBody Long[] ids){
		systemInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
