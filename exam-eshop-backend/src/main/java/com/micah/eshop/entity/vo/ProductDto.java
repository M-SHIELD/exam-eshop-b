package com.micah.eshop.entity.vo;

import com.micah.eshop.entity.ProductEntity;
import com.micah.eshop.entity.SkuEntity;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName ProductDto
 * @Description 简介
 * @Author Micah
 * @Date 2023/4/11 17:40
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
public class ProductDto extends ProductEntity {
    @ApiModelProperty(value = "sku集合")
    private List<SkuEntity> skus;
    @ApiModelProperty(value = "是否收藏")
    private Boolean isCollect;

}
