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
import com.micah.eshop.entity.SystemMessageEntity;
import com.micah.eshop.service.SystemMessageService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 系统消息表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:24
 */
@RestController
@RequestMapping("api/systemmessage")
@Api(tags = "系统消息表接口")
@RequiredArgsConstructor
@CrossOrigin
public class SystemMessageController {
    @Autowired
    private SystemMessageService systemMessageService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("系统消息表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = systemMessageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("系统消息表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SystemMessageEntity systemMessage = systemMessageService.getById(id);

        return R.ok().put("systemMessage", systemMessage);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("系统消息表:保存")
    public R save(@RequestBody SystemMessageEntity systemMessage){
		systemMessageService.save(systemMessage);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("系统消息表:更新")
    public R update(@RequestBody SystemMessageEntity systemMessage){
		systemMessageService.updateById(systemMessage);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("系统消息表:删除")
    public R delete(@RequestBody Long[] ids){
		systemMessageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
