package com.micah.goods_example.service;

import com.micah.goods_example.entity.dao.Wallet;
import com.micah.goods_example.entity.dto.WalletDTO;

import java.util.List;

public interface WalletService {
    List<Wallet> getSelectWallet(WalletDTO walletDTO);

    String rechargeWallet(WalletDTO walletDTO);
}
