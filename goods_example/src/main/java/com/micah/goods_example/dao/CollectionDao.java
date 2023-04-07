package com.micah.goods_example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.micah.goods_example.entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CollectionDao extends BaseMapper<Collection> {

    List<Collection> getAllCollectionByMaijiaId(Map<String,Object> map);

    String saveCollection(Map<String,Object> map);
}
