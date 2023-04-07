package com.micah.goods_example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.micah.goods_example.entity.dao.Collection;

import java.util.List;

public interface CollectionService extends IService<Collection> {

    List<Collection> getAllCollectionByMaijiaId(Collection collection);

    String CollectionGoods(Collection collection);
}
