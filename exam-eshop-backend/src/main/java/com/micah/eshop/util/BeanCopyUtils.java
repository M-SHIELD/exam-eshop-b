package com.micah.eshop.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 拷贝Bean 的工具类
 */
public class BeanCopyUtils {
    private BeanCopyUtils() {

    }

    /**
     * 拷贝单个对象
     *
     * @param source 数据原
     * @param clazz  目标Class
     * @param <V>
     * @return
     */
    public static <V> V copyBean(Object source, Class<V> clazz) {
        //创建目标对象
        V resutl = null;
        try {
            resutl = clazz.newInstance();
            //实现属性copy
            BeanUtils.copyProperties(source, resutl);
            //返回结果
            return resutl;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return resutl;
    }

    //拷贝list集合
    public static <V> List<V> copyBeanList(List<?> list, Class<V> clazz) {
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }


}
