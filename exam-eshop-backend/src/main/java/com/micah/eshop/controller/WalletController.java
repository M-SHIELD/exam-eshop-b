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
import com.micah.eshop.entity.dao.WalletEntity;
import com.micah.eshop.service.WalletService;
import com.micah.eshop.util.PageUtils;
import com.micah.eshop.util.R;



/**
 * 用户钱包表
 *
 * @author micah
 * @email mxmicah@qq.com
 * @date 2023-04-10 16:01:25
 */
@RestController
@RequestMapping("api/wallet")
@Api(tags = "用户钱包表接口")
@RequiredArgsConstructor
@CrossOrigin
public class WalletController {
    @Autowired
    private WalletService walletService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("用户钱包表:列表:自定义参数")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = walletService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("用户钱包表:信息:id")
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		WalletEntity wallet = walletService.getById(id);

        return R.ok().put("wallet", wallet);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("用户钱包表:保存")
    public R save(@RequestBody WalletEntity wallet){
		walletService.save(wallet);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("用户钱包表:更新")
    public R update(@RequestBody WalletEntity wallet){
		walletService.updateById(wallet);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("用户钱包表:删除")
    public R delete(@RequestBody Long[] ids){
		walletService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
