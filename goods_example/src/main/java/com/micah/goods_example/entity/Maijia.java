package com.micah.goods_example.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * (Maijia)实体类
 *
 * @author Micah
 * @since 2022-02-27 17:24:25
 */
@Accessors(chain = true)
@Data
public class Maijia implements Serializable {
    private static final long serialVersionUID = -25916112012865510L;
    
    private String majianame;
    
    private Integer maijiaid;
    
    private Integer bumenid;

}