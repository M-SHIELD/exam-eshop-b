package com.micah.goods_example.service;

import com.micah.goods_example.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getSelectCategoryAll();

    List<Category> getCategoryList();

}
