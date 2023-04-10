package com.micah.eshop.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserBo
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/7 17:24
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBo {
    //用户id
    private Integer uid;
    //用户账户(跟accout一样)
    private String username;
}
