package com.micah.goods_example.controller;

import com.micah.goods_example.entity.dao.Wallet;
import com.micah.goods_example.entity.dto.WalletDTO;
import com.micah.goods_example.service.WalletService;
import com.micah.goods_example.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "钱包相关接口")
@RequestMapping("api/wallet")
@CrossOrigin
public class WalletController {

    @Resource
    private WalletService walletService;

    @ApiOperation("查询钱包")
    @PostMapping("/getSelectWallet")
    public R getSelectWallet(@RequestBody WalletDTO walletDTO){
        List<Wallet> selectWallet = walletService.getSelectWallet(walletDTO);
        return R.ok().put("data",selectWallet);
    }

    @ApiOperation("充值钱包")
    @PostMapping("/rechargeWallet")
    public R rechargeWallet(@RequestBody WalletDTO walletDTO){
        String rechargeWallet = walletService.rechargeWallet(walletDTO);
        return R.ok().put("data",rechargeWallet);
    }
}
