package com.micah.goods_example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.goods_example.dao.RechargeSchemeDao;
import com.micah.goods_example.dao.WalletDao;
import com.micah.goods_example.entity.RechargeScheme;
import com.micah.goods_example.entity.Wallet;
import com.micah.goods_example.entity.WalletDTO;
import com.micah.goods_example.service.WalletService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WalletServiceImpl extends ServiceImpl<WalletDao, Wallet> implements WalletService {

    @Resource
    private RechargeSchemeDao rechargeSchemeDao;


    public List<Wallet> getSelectWallet(WalletDTO walletDTO) {
        return this.baseMapper.selectList(new QueryWrapper<Wallet>().eq("MaiJiaID", walletDTO.getMaijiaid()));
    }

    public String rechargeWallet(WalletDTO walletDTO) {

        String rechargeTips;

        // 获取充值方案金额
        RechargeScheme rechargeScheme = rechargeSchemeDao.selectOne(new QueryWrapper<RechargeScheme>().select("recharge_quantity", "give").eq("rid", walletDTO.getRid()));
        QueryWrapper<Wallet> wrapper = new QueryWrapper<>();
        wrapper.eq("MaiJiaID", walletDTO.getMaijiaid());
        // 获取总金额和累计充值
        Wallet wallet = this.baseMapper.selectOne(wrapper);

        //根据买家id更新总金额（当前金额+当前充值金额）和累计充值（已充值金额+当前充值金额）
        UpdateWrapper<Wallet> updateWrapper = new UpdateWrapper<>();
        switch (walletDTO.getRid()) {
            case 1: //如果当前充值方案为1，那么充值100增10
                updateWrapper.eq("MaiJiaID", walletDTO.getMaijiaid())
                        .set("money", wallet.getMoney() + rechargeScheme.getRechargeQuantity() + rechargeScheme.getGive())
                        .set("total_recharge", wallet.getTotalRecharge() + rechargeScheme.getRechargeQuantity() + rechargeScheme.getGive());
                update(updateWrapper);
                rechargeTips = "充值成功";
                break;

            case 2: //如果当前充值方案为1，那么充值1增1000
                updateWrapper.eq("MaiJiaID", walletDTO.getMaijiaid())
                        .set("money", wallet.getMoney() + rechargeScheme.getRechargeQuantity() + rechargeScheme.getGive())
                        .set("total_recharge", wallet.getTotalRecharge() + rechargeScheme.getRechargeQuantity() + rechargeScheme.getGive());
                update(updateWrapper);
                rechargeTips = "充值成功";
                break;

            default:
                rechargeTips = "充值失败，请联系工作人员";
        }
        return rechargeTips;
    }
}
