package com.micah.goods_example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.goods_example.dao.CategoryDao;
import com.micah.goods_example.entity.dao.Category;
import com.micah.goods_example.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Override
    public List<Category> getSelectCategoryAll() {
        List<Category> categories = new ArrayList<>();
        return categories;
    }

    @Override
    public List<Category> getCategoryList() {
        //先获取所有分类
        List<Category> all = this.baseMapper.selectList(null);
        //获取当前一级分类 这里就不循环查库了,直接提取方法
        List<Category> lv1 = getCategories(all, 0);
        lv1.forEach(e -> {
            //遍历当前id之下是否存在子集
            List<Category> lv2 = getCategories(all, e.getCid());
            if (lv2.size() > 0)//存在
            {
                //此时还差一层遍历
                lv2.forEach(e1->{
                    List<Category> lv3 = getCategories(all, e1.getCid());
                    if (lv3.size()>0)
                        e1.setChildren(lv3);
                });
                e.setChildren(lv2);//传入
            }
        });
        return lv1;
    }

    /**
     * 根据父id获取当前集合
     *
     * @param list     总集合
     * @param parentId 父id
     * @return 父id等于传进来的id的值
     */
    private List<Category> getCategories(List<Category> list, Integer parentId) {
//        return this.baseMapper.selectList(new QueryWrapper<Category>().eq("parentId", 0));
        return list.stream().filter(e -> e.getParentId() == parentId).collect(Collectors.toList());
    }

}
