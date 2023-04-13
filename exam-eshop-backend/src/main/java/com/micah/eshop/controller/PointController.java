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
import com.micah.eshop.entity.dao.PointEntity;
import com.micah.eshop.service.PointService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 积分表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@RestController
@RequestMapping("api/point")
@Api(tags = "积分表接口")
@RequiredArgsConstructor
@CrossOrigin
public class PointController {
    @Autowired
    private PointService pointService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("积分表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pointService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("积分表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		PointEntity point = pointService.getById(id);

        return R.ok().put("point", point);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("积分表:保存")
    public R save(@RequestBody PointEntity point){
		pointService.save(point);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("积分表:更新")
    public R update(@RequestBody PointEntity point){
		pointService.updateById(point);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("积分表:删除")
    public R delete(@RequestBody Long[] ids){
		pointService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
