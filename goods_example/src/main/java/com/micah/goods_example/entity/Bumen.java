package com.micah.goods_example.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (Bumen)实体类
 *
 * @author Micah
 * @since 2022-02-27 17:24:25
 */
@Accessors(chain = true)
@Data
public class Bumen implements Serializable {
    private static final long serialVersionUID = -16349499835964530L;
    
    private Integer bumenid;
    
    private String bumenname;

}