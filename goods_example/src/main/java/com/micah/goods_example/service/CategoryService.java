package com.micah.goods_example.service;

import com.micah.goods_example.entity.dao.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getSelectCategoryAll();

    List<Category> getCategoryList();

}
