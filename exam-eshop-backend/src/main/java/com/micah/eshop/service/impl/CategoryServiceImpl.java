package com.micah.eshop.service.impl;

import com.micah.eshop.entity.model.PageParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.micah.eshop.util.PageUtils;
//import com.micah.common.utils.Query;

import com.micah.eshop.dao.CategoryDao;
import com.micah.eshop.entity.dao.CategoryEntity;
import com.micah.eshop.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(PageParam params) {

        IPage<CategoryEntity> iPage = new Page<>(params.getCurrent(), params.getSize());
        IPage<CategoryEntity> page = this.page(
                iPage,
                new QueryWrapper<CategoryEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> getAllCategory() {
        //先获取所有分类
        List<CategoryEntity> all = this.baseMapper.selectList(null);
        //获取当前一级分类 这里就不循环查库了,直接提取方法
        List<CategoryEntity> lv1 = getCategories(all, 0);
        lv1.forEach(e -> {
            //遍历当前id之下是否存在子集
            List<CategoryEntity> lv2 = getCategories(all, e.getId());
            if (lv2.size() > 0)//存在
            {
                //此时还差一层遍历
                lv2.forEach(e1->{
                    List<CategoryEntity> lv3 = getCategories(all, e1.getId());
                    if (lv3.size()>0) {
                        e1.setChildren(lv3);
                    }
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
    private List<CategoryEntity> getCategories(List<CategoryEntity> list, Integer parentId) {

        return list.stream().filter(e -> e.getParentId().equals(parentId)).collect(Collectors.toList());
    }

}
