package com.micah.goods_example.entity.dao;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (Address)实体类
 *
 * @author Micah
 * @since 2022-02-27 17:24:25
 */
@Accessors(chain = true)
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = 655704997422376583L;

    private Integer 地址id;

    private String 地址;

}
